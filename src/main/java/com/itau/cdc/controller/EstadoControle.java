package com.itau.cdc.controller;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.itau.cdc.DTO.EstadoRequest;
import com.itau.cdc.service.EstadoService;
import com.itau.cdc.validator.ProibeEstadoDuplicadoValidator;

@RestController
public class EstadoControle {

	@Autowired
	private EstadoService estadoService;
	
	@Autowired
	private ProibeEstadoDuplicadoValidator proibeEstadoDuplicadoValidator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(proibeEstadoDuplicadoValidator);
	}
	
	@PostMapping("/v1/estados")
	@Transactional
	public ResponseEntity<?> CriaEstado(@RequestBody @Valid EstadoRequest request, UriComponentsBuilder builder){
		
		Long idEstado = estadoService.IncluirEstado(request);
		
		URI enderecoConsulta = builder.path("/v1/estados/{id}").build(idEstado);
		
		return ResponseEntity.created(enderecoConsulta).build();
		
	}
}
