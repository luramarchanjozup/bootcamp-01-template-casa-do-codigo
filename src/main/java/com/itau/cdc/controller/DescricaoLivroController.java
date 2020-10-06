package com.itau.cdc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.itau.cdc.DTO.DetalheSiteLivroResponse;
import com.itau.cdc.service.DescricaoLivroServiceService;

@RestController
public class DescricaoLivroController {

	@Autowired
	private DescricaoLivroServiceService descricaoLivroService;
	
	@GetMapping("/v1/livros/{id_livro}")
	public ResponseEntity<?> DescricaoLivro(@PathVariable("id_livro") Long idLivro, UriComponentsBuilder builder){
		
		DetalheSiteLivroResponse livro = descricaoLivroService.DescricaoLivro(idLivro);
		
		if (livro == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(livro);
		}

	}
	
}
