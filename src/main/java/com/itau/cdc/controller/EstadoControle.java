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

import com.itau.cdc.DTO.EstadoRequest;
import com.itau.cdc.service.EstadoService;

@RestController
public class EstadoControle {

	@Autowired
	//1
	private EstadoService estadoService;
	
	@PostMapping("/v1/estados")
	@Transactional
	//1
	public ResponseEntity<?> CriaEstado(@RequestBody @Valid EstadoRequest request, UriComponentsBuilder builder){
		//1
		Long idEstado = estadoService.IncluirEstado(request);
		//1
		URI enderecoConsulta = builder.path("/v1/estados/{id}").build(idEstado);
		
		return ResponseEntity.created(enderecoConsulta).build();
		
	}
}
