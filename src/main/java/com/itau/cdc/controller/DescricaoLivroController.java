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
//4
public class DescricaoLivroController {

	@Autowired
	//1
	private DescricaoLivroServiceService descricaoLivroService;
	
	@GetMapping("/v1/livros/{id_livro}")
	//1
	public ResponseEntity<?> DescricaoLivro(@PathVariable("id_livro") Long idLivro, UriComponentsBuilder builder){
		//1
		DetalheSiteLivroResponse livro = descricaoLivroService.DescricaoLivro(idLivro);
		//1
		if (livro == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(livro);
		}

	}
	
}
