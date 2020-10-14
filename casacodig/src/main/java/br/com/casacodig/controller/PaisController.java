package br.com.casacodig.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.casacodig.dto.PaisDTO;
import br.com.casacodig.model.Pais;
import br.com.casacodig.services.PaisServices;


//Contagem de Pontos - TOTAL:3
//1 - PaisServices
//1 - PaisDTO
//1 - Pais

@RestController
public class PaisController {
	
	@Autowired
	private PaisServices paisService;

	@PersistenceContext
	private EntityManager manager;
	

	@PostMapping(value = "/v1/pais")
	@Transactional
	public ResponseEntity<?> cria(@Valid @RequestBody PaisDTO paisdto) {
		Pais pais = paisService.salvar(paisdto);
		return new ResponseEntity<>(pais,HttpStatus.OK);	
	}
	
	
}
