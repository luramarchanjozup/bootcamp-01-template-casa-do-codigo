package com.guiferrini.CasaCodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
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
	@Transactional//1
	public ResponseEntity<?> detalheCompra(@PathVariable("id") String id) {
		//1
		FluxoPagto obj = entityManager.find(FluxoPagto.class, id);
		
		//1 - Não consegui fazer sem validação do retorno nulo. Caso vc saiba me fala :) valeu!
		if(obj == null) {
			return ResponseEntity.status(400).body("ERRO. Favor verificar");
		}
		
		//1
		FluxoPagtoResponse fluxoPagtoResponse = new FluxoPagtoResponse(obj);
		
		return ResponseEntity.status(200).body(fluxoPagtoResponse);				
	}
	
}
