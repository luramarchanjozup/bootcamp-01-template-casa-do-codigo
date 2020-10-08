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
//4
@RestController
public class AutorController {
	//1
	@Autowired
	private AutorService autorService;

	@PostMapping("/v1/autores")
	@Transactional
	//1
	public ResponseEntity<?> CriaAutor(@RequestBody @Valid AutorRequest request, UriComponentsBuilder builder){
		//1
		Long idAutor = autorService.IncluirAutor(request);
		//1
		URI enderecoConsulta = builder.path("/v1/autores/{id}").build(idAutor);
		
		return ResponseEntity.created(enderecoConsulta).build();
	}
	
}
