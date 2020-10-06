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

import com.itau.cdc.DTO.AutorRequest;
import com.itau.cdc.service.AutorService;

@RestController
public class AutorController {

	@Autowired
	private AutorService autorService;

	//1
	@PostMapping("/v1/autores")
	@Transactional
	public ResponseEntity<?> CriaAutor(@RequestBody @Valid AutorRequest request, UriComponentsBuilder builder){
		//1
		Long idAutor = autorService.IncluirAutor(request);
		
		URI enderecoConsulta = builder.path("/v1/autores/{id}").build(idAutor);
		
		return ResponseEntity.created(enderecoConsulta).build();
	}
	
}
