package br.com.casacodig.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.casacodig.dto.LivroDTO;
import br.com.casacodig.model.Livro;
import br.com.casacodig.services.LivroServices;


//Contagem de Pontos - TOTAL:4
//1 - LivroServices
//1 - LivroDTO
//1 - Livro
//1 - If

@RestController
public class LivroController {
	
	@Autowired
	private LivroServices livroservice;
	
	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping(value = "/v1/livro", produces = "application/json")
	@Transactional
	public ResponseEntity<?> criarLivro(@Valid @RequestBody LivroDTO livrodto) {
		Livro livro = livroservice.salvar(livrodto);
		return new ResponseEntity<>(livro, HttpStatus.OK);
	}
	
	@GetMapping(value = "/v1/livro/listar", produces = "application/json")
	public ResponseEntity<?> listaLivro() {
		List<Livro> livros = livroservice.listarLivros();
		return new ResponseEntity<>(livros, HttpStatus.OK);
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
