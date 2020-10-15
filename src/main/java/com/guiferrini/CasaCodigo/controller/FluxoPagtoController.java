package com.guiferrini.CasaCodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guiferrini.CasaCodigo.model.EstadoPaisValidador;
import com.guiferrini.CasaCodigo.model.FluxoPagto;
import com.guiferrini.CasaCodigo.model.FluxoPagtoDTO;

@RestController
@RequestMapping("/pagto")
public class FluxoPagtoController {
	
	@PersistenceContext
	EntityManager entityManager;
	
	//Validando se o Estado pertence ao Pais
	@Autowired
	EstadoPaisValidador estadoPaisValidador;
	
	@InitBinder
	public void init(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(estadoPaisValidador);
	}
	
	@PostMapping
	@Transactional
	public FluxoPagto cria(@Valid @RequestBody FluxoPagtoDTO fluxoPagtoDTO) {
		
		FluxoPagto obj = fluxoPagtoDTO.toModel(entityManager);
		entityManager.persist(obj);
		
		return obj;
	}
}