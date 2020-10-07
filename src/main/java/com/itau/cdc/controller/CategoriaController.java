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
//4
public class CategoriaController {

	@Autowired
	//1
	private CategoriaService categoriaService;
	
	@PostMapping("/v1/categorias")
	@Transactional
	//1
	public ResponseEntity<?> CriaCategoria(@RequestBody @Valid CategoriaRequest request, UriComponentsBuilder builder){
		//1
		Long idCategoria = categoriaService.IncluirCategoria(request);
		//1
		URI enderecoConsulta = builder.path("/v1/categorias/{id}").build(idCategoria);
		
		return ResponseEntity.created(enderecoConsulta).build();
		
	}
	
}
