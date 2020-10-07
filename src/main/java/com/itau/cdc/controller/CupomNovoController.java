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

import com.itau.cdc.DTO.CupomRequest;
import com.itau.cdc.service.CupomNovoService;

@RestController
//4
public class CupomNovoController {

	@Autowired
	//1
	private CupomNovoService novoCupomService;
	
	@PostMapping("/v1/cupons")
	@Transactional
	//1
	private ResponseEntity<?> NovoCupom(@RequestBody @Valid CupomRequest request, UriComponentsBuilder builder){
		//1
		Long idCupom = novoCupomService.NovoCupom(request);
		//1
		URI enderecoConsulta = builder.path("/v1/cupons/{id}").build(idCupom);
		
		return ResponseEntity.created(enderecoConsulta).build();
	}
	
	
	
}
