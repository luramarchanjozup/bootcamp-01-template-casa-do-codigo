package br.com.itau.casadocodigo.casadocodigoAPI.controller.livro;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

//import br.com.itau.casadocodigo.casadocodigoAPI.config.validacao.EmailValidator;
import br.com.itau.casadocodigo.casadocodigoAPI.controller.form.AutorForm;
import br.com.itau.casadocodigo.casadocodigoAPI.controller.form.CategoriaForm;
import br.com.itau.casadocodigo.casadocodigoAPI.controller.form.LivroForm;
import br.com.itau.casadocodigo.casadocodigoAPI.model.Autor;
import br.com.itau.casadocodigo.casadocodigoAPI.model.Categoria;
import br.com.itau.casadocodigo.casadocodigoAPI.model.Livro;
import br.com.itau.casadocodigo.casadocodigoAPI.model.dto.LivroDTO;
import br.com.itau.casadocodigo.casadocodigoAPI.repository.AutorRepository;
import br.com.itau.casadocodigo.casadocodigoAPI.repository.CategoriaRepository;
import br.com.itau.casadocodigo.casadocodigoAPI.repository.LivroRepository;

@RestController
@RequestMapping(value = "casadocodigo/livro/")
public class LivroController {

	// 1
	private AutorRepository autorRepository;
	// 1
	private CategoriaRepository categoriaRepository;
	// 1
	private LivroRepository livroRepository;

	public LivroController(AutorRepository autorRepository, CategoriaRepository categoriaRepository,
			LivroRepository livroRepository) {
		this.autorRepository = autorRepository;
		this.categoriaRepository = categoriaRepository;
		this.livroRepository = livroRepository;
	}

	@PostMapping(value = "inserirLivro")
	@Transactional
	// 1
	public ResponseEntity<LivroDTO> inserirLivro(@RequestBody(required = true) @Valid LivroForm livroForm,
			UriComponentsBuilder uriBuilder) {

		// 1
		Optional<Autor> autor = autorRepository.findByNome(livroForm.getAutor());
		// 1
		Optional<Categoria> categoria = categoriaRepository.findByNome(livroForm.getCategoria());
		// 1
		Livro livro = livroForm.converter(autor, categoria);
		livroRepository.save(livro);

		URI uri = uriBuilder.path("/categoria/{id}").buildAndExpand(livro.getId()).toUri();
		return ResponseEntity.created(uri)
				.body(new LivroDTO(livro.getId(), livro.getTitulo(), livro.getResumoLivro(), livro.getSumario(),
						livro.getPreco(), livro.getNroPaginas(), livro.getIdentificadorISBN(),
						livro.getDataPublicacao(), autor.get().getNome(), categoria.get().getNome()));

	}

	@GetMapping(value = "/listarLivros")
	@Transactional
	public ResponseEntity<List<Livro>> listarLivros() {

		List<Livro> livros = livroRepository.findAll();

		return ResponseEntity.ok().body(livros);

	}

	@GetMapping(value = "/listarLivros/{id}")
	@Transactional
	public ResponseEntity<Optional<Livro>> listarLivrosPorId(@PathVariable(required = true) int id) {

		Optional<Livro> livro = livroRepository.findById(id);

		if (livro.isPresent()) {
			return ResponseEntity.ok().body(livro);
		}

		return ResponseEntity.notFound().build();

	}

}
