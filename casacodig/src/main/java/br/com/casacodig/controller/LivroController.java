package br.com.casacodig.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.casacodig.dto.CategoriaDTO;
import br.com.casacodig.dto.LivroDTO;
import br.com.casacodig.error.ApiErroException;
import br.com.casacodig.model.Categoria;
import br.com.casacodig.model.Livro;
import br.com.casacodig.services.CategoriaServices;
import br.com.casacodig.services.LivroServices;

@RestController
public class LivroController {
	
	@Autowired
	private LivroServices livroservice;
	
	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping(value = "/v1/livro")
	@Transactional
	public String criarLivro(@Valid @RequestBody LivroDTO livrodto) {
		try {
			Livro livro = livroservice.salvar(livrodto);
			manager.persist(livro);
			return livro.toString();
		} catch (Exception e) {
			throw new ApiErroException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@GetMapping(value = "/v1/livro/listar", produces = "application/json")
	public ResponseEntity<?> listaLivro() {
		try {
			List livros = livroservice.listarLivros();
			return new ResponseEntity<>(livros, HttpStatus.OK);
		} catch (Exception e) {
			throw new ApiErroException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@GetMapping(value = "/v1/livro/{id}", produces = "application/json")
	public ResponseEntity<?> detalheLivro(@PathVariable("id") Long id) {
		Livro livro = livroservice.listarId(id);
		if (livro == null) {
			return new ResponseEntity<>("Não Encontrado um Livro com ID informado",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(livro, HttpStatus.OK);
	}

}
