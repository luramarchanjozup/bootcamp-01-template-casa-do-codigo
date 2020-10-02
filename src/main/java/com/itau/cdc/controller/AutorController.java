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

import com.itau.cdc.model.DTO.NovoAutorRequest;
import com.itau.cdc.service.AutorService;
import com.itau.cdc.validator.ProibeEmailDuplicadoAutorValidator;

@RestController
public class AutorController {

	@Autowired
	private AutorService autorService;
	
	//1
	@Autowired
	private ProibeEmailDuplicadoAutorValidator proibeEmailDuplicadoAutorValidator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(proibeEmailDuplicadoAutorValidator);
	}

	//1
	@PostMapping("/v1/autor")
	@Transactional
	public ResponseEntity<?> CriaAutor(@RequestBody @Valid NovoAutorRequest request, UriComponentsBuilder builder){
		//1
		Long idAutor = autorService.IncluirAutor(request);
		
		URI enderecoConsulta = builder.path("/v1/autor/{id}").build(idAutor);
		
		return ResponseEntity.created(enderecoConsulta).build();
		
	}
	
}
