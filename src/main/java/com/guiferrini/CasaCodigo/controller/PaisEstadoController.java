package com.guiferrini.CasaCodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guiferrini.CasaCodigo.model.Categoria;
import com.guiferrini.CasaCodigo.model.CategoriaDTO;
import com.guiferrini.CasaCodigo.model.Pais;
import com.guiferrini.CasaCodigo.model.PaisDTO;

@RestController
@RequestMapping("/paisestado")
public class PaisEstadoController {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	@PostMapping(value="/pais")
	public Pais criaPais(@Valid @RequestBody PaisDTO paisDTO) {
		
		Pais obj = new Pais(paisDTO.getNome());
		entityManager.persist(obj);
		
		return obj;
	}
}	