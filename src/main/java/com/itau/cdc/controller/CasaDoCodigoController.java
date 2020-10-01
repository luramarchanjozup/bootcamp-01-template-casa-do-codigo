package com.itau.cdc.controller;

import java.net.URI;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

import com.itau.cdc.model.Autor;
import com.itau.cdc.model.DTO.NovoAutorRequest;
import com.itau.cdc.service.AutorService;
import com.itau.cdc.validator.proibeEmailDuplicadoAutorValidator;

@RestController
public class CasaDoCodigoController {

	@Autowired
	private AutorService autorService;
	
	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private proibeEmailDuplicadoAutorValidator proibeEmailDuplicadoAutorValidator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(proibeEmailDuplicadoAutorValidator);
	}
	
	@PostMapping("/v1/autor")
	@Transactional
	public ResponseEntity<?> CriaAutor(@RequestBody @Valid NovoAutorRequest request, UriComponentsBuilder builder){
		
		Autor novoAutor = request.toModel();
		
		Long idAutor = autorService.IncluirAutor(novoAutor);
		
		URI enderecoConsulta = builder.path("/v1/autor/{id}").build(idAutor);
		
		return ResponseEntity.created(enderecoConsulta).build();
		
	}
	
}
