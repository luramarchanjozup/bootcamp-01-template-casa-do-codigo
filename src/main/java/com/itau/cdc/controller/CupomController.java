package com.itau.cdc.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.itau.cdc.DTO.CupomRequest;
import com.itau.cdc.model.Cupom;
import com.itau.cdc.service.NovoCupomService;

@RestController
public class CupomController {

	@Autowired
	private NovoCupomService novoCupomService;
	
	@PostMapping("/v1/cupons")
	@Transactional
	private ResponseEntity<?> NovoCupom(@RequestBody @Valid CupomRequest request, UriComponentsBuilder builder){
		
		Long idCupom = novoCupomService.NovoCupom(request);
		
		URI enderecoConsulta = builder.path("/v1/cupons/{id}").build(idCupom);
		
		return ResponseEntity.created(enderecoConsulta).build();
	}
	
	@GetMapping("/v1/cupons/{id_cupom}")
	@Transactional
	private ResponseEntity<?> ConsultaCupom(@PathVariable("id_cupom") Long idCupom){
		
		Optional<Cupom> cupom = novoCupomService.ConsultaCupom(idCupom);
		
		if(cupom.isPresent()) {
			return ResponseEntity.ok(cupom);
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
}
