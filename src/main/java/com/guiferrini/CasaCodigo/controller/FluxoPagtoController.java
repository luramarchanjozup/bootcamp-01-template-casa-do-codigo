package com.guiferrini.CasaCodigo.controller;

import java.net.URI;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.guiferrini.CasaCodigo.model.CuponValidoValidador;
import com.guiferrini.CasaCodigo.model.EstadoPaisValidador;
import com.guiferrini.CasaCodigo.model.FluxoPagto;
import com.guiferrini.CasaCodigo.model.FluxoPagtoDTO;
import com.guiferrini.CasaCodigo.model.FluxoPagtoResponse;

@RestController
@RequestMapping("/pagto")
public class FluxoPagtoController {
	
	@PersistenceContext
	EntityManager entityManager;
	
	//Validando se o Estado pertence ao Pais
	@Autowired
	EstadoPaisValidador estadoPaisValidador;
	
	@Autowired
	private CuponValidoValidador cuponValidoValidador;

	@InitBinder
	public void init(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(estadoPaisValidador, cuponValidoValidador);
	}

	//public FluxoPagto cria(@Valid @RequestBody FluxoPagtoDTO fluxoPagtoDTO) { - referencia p outro tipo de retorno
	@PostMapping
	@Transactional
	public ResponseEntity<FluxoPagto> cria(@Valid @RequestBody FluxoPagtoDTO fluxoPagtoDTO) {	
		
		FluxoPagto obj = fluxoPagtoDTO.toModel(entityManager);
		entityManager.persist(obj);
				
		//UriComponentsBuilder builder - Alternativa de retorno URI
		//return ResponseEntity.created(builder.path("/pagto/{id}").buildAndExpand(obj.getId()).toUri()).build();
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		//return obj;
		
		if(obj instanceof FluxoPagto) {
			//return ResponseEntity.created(uri).build();
			return ResponseEntity.status(201).body(obj);
		} else {
			return ResponseEntity.status(400).body(obj);
		}	
	}
}