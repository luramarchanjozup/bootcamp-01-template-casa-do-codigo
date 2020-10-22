package com.guiferrini.CasaCodigo.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guiferrini.CasaCodigo.model.Cupon;
import com.guiferrini.CasaCodigo.model.CuponDTO;
import com.guiferrini.CasaCodigo.model.CuponDuplicadoValidador;

@RestController
@RequestMapping("/cupon")
public class CuponController {

	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	private CuponDuplicadoValidador cuponDuplicadoValidador;
	
	@InitBinder
	public void init(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(cuponDuplicadoValidador);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<String> criaCupon(@Valid @RequestBody CuponDTO cuponDTO) {
		
		//Cupon obj = new Cupon(cuponDTO.getCodigo(), cuponDTO.getDesconto(), cuponDTO.getDate());
		Cupon obj = cuponDTO.toModel();
		entityManager.persist(obj);

		if(obj instanceof Cupon) {
			return ResponseEntity.status(201).body(obj.toString());
		} else {
			return ResponseEntity.status(400).body(obj.toString());
		}
	}
	
	
}
