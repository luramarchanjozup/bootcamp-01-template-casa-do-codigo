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

import com.itau.cdc.DTO.PaisRequest;
import com.itau.cdc.service.PaisService;

@RestController
public class PaisController {

	@Autowired
	private PaisService paisService;
	
	@PostMapping("/v1/paises")
	@Transactional
	public ResponseEntity<?> CriaPais(@RequestBody @Valid PaisRequest request, UriComponentsBuilder builder){
		
		Long idPais = paisService.IncluirPais(request);
		
		URI enderecoConsulta = builder.path("/v1/paises/{id}").build(idPais);
		
		return ResponseEntity.created(enderecoConsulta).build();
		
	}
	
}
