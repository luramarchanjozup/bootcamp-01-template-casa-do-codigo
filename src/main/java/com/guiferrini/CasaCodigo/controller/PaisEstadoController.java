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

import com.guiferrini.CasaCodigo.model.Estado;
import com.guiferrini.CasaCodigo.model.EstadoDTO;
import com.guiferrini.CasaCodigo.model.EstadoPaisValidador;
import com.guiferrini.CasaCodigo.model.Pais;
import com.guiferrini.CasaCodigo.model.PaisDTO;

@RestController
@RequestMapping("/paisestado")
public class PaisEstadoController {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	@PostMapping(value="/pais")//1
	public Pais criaPais(@Valid @RequestBody PaisDTO paisDTO) {
		//1
		Pais obj = new Pais(paisDTO.getNome());
		entityManager.persist(obj);
		
		return obj;
	}
	
	@PostMapping(value="/pais/estado")
	@Transactional//1
	public Estado criaEstado(@Valid @RequestBody EstadoDTO estadoDTO) {
		//1
		Estado obj = estadoDTO.toModel(entityManager);
		entityManager.persist(obj); 
		
		return obj;
	}
}	