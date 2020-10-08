package com.itau.cdc.controller;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itau.cdc.DTO.CupomRequest;
import com.itau.cdc.entity.Cupom;
import com.itau.cdc.service.CupomConsultaService;

@RestController
//5
public class CupomConsultaController {

	@Autowired
	//1
	private CupomConsultaService cupomConsultaService;
	
	@GetMapping("/v1/cupons/{codigo_cupom}")
	@Transactional
	//1
	private ResponseEntity<?> ConsultaCupom(@PathVariable("codigo_cupom") String codigoCupom){
		//1
		Optional<Cupom> cupom = cupomConsultaService.ConsultaCupom(codigoCupom);
		
		return ResponseEntity.ok(cupom);
	}
	
	@PutMapping("/v1/cupons/{codigo_cupom}")
	@Transactional
	//1
	private ResponseEntity<?> AlteraCupom(@PathVariable("codigo_cupom") String codigoCupom, @RequestBody @Valid CupomRequest request){
		//1
		Cupom cupom = cupomConsultaService.AlteraCupom(codigoCupom, request);
		
		return ResponseEntity.ok(cupom);
		
	}
	
}
