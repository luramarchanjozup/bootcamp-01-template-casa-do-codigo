package com.itau.cdc.controller;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.itau.cdc.DTO.CategoriaRequest;
import com.itau.cdc.service.CategoriaService;

@RestController
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	@PostMapping("/v1/categorias")
	@Transactional
	public ResponseEntity<?> CriaCategoria(@RequestBody @Valid CategoriaRequest request, UriComponentsBuilder builder){
		//1
		Long idCategoria = categoriaService.IncluirCategoria(request);
		
		URI enderecoConsulta = builder.path("/v1/categorias/{id}").build(idCategoria);
		
		return ResponseEntity.created(enderecoConsulta).build();
		
	}
	
}
