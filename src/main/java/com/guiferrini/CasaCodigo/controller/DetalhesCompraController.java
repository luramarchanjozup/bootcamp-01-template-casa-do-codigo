package com.guiferrini.CasaCodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guiferrini.CasaCodigo.model.FluxoPagto;
import com.guiferrini.CasaCodigo.model.FluxoPagtoResponse;

@RestController
@RequestMapping
public class DetalhesCompraController {

	@PersistenceContext
	EntityManager entityManager;
	
	@GetMapping("pagto/{id}")
	@Transactional
	public ResponseEntity detalheCompra(@PathVariable("id") String id) {
		
		FluxoPagto obj = entityManager.find(FluxoPagto.class, id); //retorno nulo ?!
		
		FluxoPagtoResponse fluxoPagtoResponse = new FluxoPagtoResponse(obj);
		return ResponseEntity.status(200).body(fluxoPagtoResponse);
	}
	
}
