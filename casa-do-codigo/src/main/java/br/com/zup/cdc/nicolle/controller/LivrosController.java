package br.com.zup.cdc.nicolle.controller;


import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.cdc.nicolle.model.Livro;
import br.com.zup.cdc.nicolle.repository.AutorRepository;
import br.com.zup.cdc.nicolle.repository.CategoriaRepository;
import br.com.zup.cdc.nicolle.repository.LivroRepository;
import br.com.zup.cdc.nicolle.request.NovoLivroRequest;
import br.com.zup.cdc.nicolle.response.DetalhesDoLivroResponse;
import br.com.zup.cdc.nicolle.response.LivroResponse;

@RestController
@RequestMapping(value = "/casadocodigo/livros")
public class LivrosController {
	
	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private AutorRepository autorRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<Livro> novo(@RequestBody @Valid NovoLivroRequest request) {
		Livro novoLivro = request.novoLivro(autorRepository, categoriaRepository);
		livroRepository.save(novoLivro);
		return ResponseEntity.ok().build();
	}


	@GetMapping
	@Cacheable(value = "/todos")
	public Page<LivroResponse> lista(@RequestParam(required = false) String titulo, 
			@PageableDefault(sort = "id", direction = Direction.DESC, page = 0, size = 20) Pageable paginacao){
		
		if (titulo == null) {
			Page<Livro> livros = livroRepository.findAll(paginacao);
			return LivroResponse.converter(livros);
		} else {
			Page<Livro> livros = livroRepository.findByTitulo(titulo, paginacao);
			return LivroResponse.converter(livros);
		}
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesDoLivroResponse> detalhar(@PathVariable Long id) {
		Optional<Livro> livro = livroRepository.findById(id);
		if(livro.isPresent()) {
			return ResponseEntity.ok(new DetalhesDoLivroResponse(livro.get()));
		}
		return ResponseEntity.notFound().build();
	}

	
}
