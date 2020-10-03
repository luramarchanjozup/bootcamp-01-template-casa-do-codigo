package com.itau.cdc.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.itau.cdc.DTO.NovoLivroRequest;
import com.itau.cdc.model.Livro2;
import com.itau.cdc.service.LivroService;

@RestController
public class LivrosController {

	@Autowired
	private LivroService livroService;
	
	@PostMapping("/v1/livros")
	@Transactional
	public ResponseEntity<?> CriaLivro(@RequestBody @Valid NovoLivroRequest request, UriComponentsBuilder builder){
		
		Long idLivro = livroService.IncluirLivro(request);
		
		URI enderecoConsulta = builder.path("/v1/livros/{id}").build(idLivro);
		
		return ResponseEntity.created(enderecoConsulta).build();
	}
	
	@GetMapping("/v1/livros")
	@Transactional
	public ResponseEntity<?> RetornaListaLivros(UriComponentsBuilder builder){

		Iterable<Livro2> livros = livroService.ListaLivros();
		
		return ResponseEntity.ok(livros);
		
	}
	
}
