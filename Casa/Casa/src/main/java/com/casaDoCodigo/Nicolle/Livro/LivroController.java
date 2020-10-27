package com.casaDoCodigo.Nicolle.Livro;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.casaDoCodigo.Nicolle.Autor.AutorRepository;
import com.casaDoCodigo.Nicolle.Categoria.CategoriaRepository;

@RestController
@RequestMapping
public class LivroController {
	
	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private AutorRepository autorRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	//adicionar livros e detalhes
	@PostMapping(value = "/casa/livro")
	@Transactional
	@ResponseStatus(HttpStatus.CREATED)
	public void novo(@RequestBody @Valid NovoLivroForm form) {
		Livro novoLivro = form.novoLivro(autorRepository, categoriaRepository);
		livroRepository.save(novoLivro);
	}
	
	
	//Achar todos livros e detalhes
	@GetMapping(value = "/casa/livro/tudo")
	public Collection<LivroListar> lista() {
		return livroRepository.findAll().stream().map(LivroListar :: new).collect(Collectors.toList());
	}
	
	
	//Achar apenas nome do livro e autor
	@GetMapping(value = "/casa/livro/simples")
	public Collection<LivroListarSimples> listar() {
		return livroRepository.findAll().stream().map(LivroListarSimples :: new).collect(Collectors.toList());
	}
	
	
	
}
