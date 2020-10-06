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

import com.itau.cdc.DTO.CompraRequest;
import com.itau.cdc.service.NovaCompraService;

@RestController
public class NovaCompraController {

	@Autowired
	private NovaCompraService novaCompraService;
	
	@PostMapping("/v1/compras")
	@Transactional
	public ResponseEntity<?> NovaCompra (@RequestBody @Valid CompraRequest request,  UriComponentsBuilder builder){
		
		Long idCompra = novaCompraService.NovaCompra(request);
		
		URI enderecoConsulta = builder.path("/v1/compras/{id}").build(idCompra);
		
		return ResponseEntity.created(enderecoConsulta).build();
		
	}
	
}
