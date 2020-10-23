package com.guiferrini.CasaCodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	//1
	@Autowired
	private CuponDuplicadoValidador cuponDuplicadoValidador;
	
	@InitBinder
	public void init(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(cuponDuplicadoValidador);
	}
	
	@PostMapping
	@Transactional//1
	public ResponseEntity<String> criaCupon(@Valid @RequestBody CuponDTO cuponDTO) {
		//1
		Cupon obj = cuponDTO.toModel();
		entityManager.merge(obj);
		//1
		if(obj instanceof Cupon) {
			return ResponseEntity.status(201).body(obj.toString());
		} else {//1
			return ResponseEntity.status(400).body(obj.toString());
		}
	}
	
	@PutMapping("/{id}")
	@Transactional//1
	public ResponseEntity<String> alterarCupon(@Valid @RequestBody CuponDTO cuponDTO, @PathVariable String id) {
		//1
		Cupon cupon = entityManager.find(Cupon.class, id); //busco id do Cupon existente
		
		entityManager.merge(cupon); //Solicito as atualização p gravar
		
		//Efetua as atualizaçoes/grava
		cupon.setCodigo(cuponDTO.getCodigo());
        cupon.setDesconto(cuponDTO.getDesconto());
        cupon.setValidade(cuponDTO.getValidade());

        return ResponseEntity.status(200).body(cupon.toString());
		
		
	}
	
	
}
