package com.itau.cdc.controller;

import java.net.URI;

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

import com.itau.cdc.DTO.CompraRequest;
import com.itau.cdc.DTO.CompraResponse;
import com.itau.cdc.service.NovaCompraService;
import com.sun.istack.NotNull;

@RestController
public class NovaCompraController {

	@Autowired
	//1
	private NovaCompraService novaCompraService;
	
	@PostMapping("/v1/compras")
	@Transactional
	//1
	public ResponseEntity<?> NovaCompra (@RequestBody @Valid CompraRequest request,  UriComponentsBuilder builder){
		//1
		Long idCompra = novaCompraService.NovaCompra(request);
		//1
		URI enderecoConsulta = builder.path("/v1/compras/{id}").build(idCompra);
		
		return ResponseEntity.created(enderecoConsulta).build();
	}
	
	@GetMapping("/v1/compras/{id_compra}")
	@Transactional
	//1
	public ResponseEntity<?> ConsultaCompra (@PathVariable("id_compra") @NotNull Long id_compra){
		//1
		CompraResponse compra = novaCompraService.consultaCompra(id_compra);
		//1
		if(compra == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(compra);
		}
	}
	
}
