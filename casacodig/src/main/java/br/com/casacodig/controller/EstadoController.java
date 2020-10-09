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

import br.com.casacodig.dto.EstadoDTO;
import br.com.casacodig.dto.PaisDTO;
import br.com.casacodig.error.ApiErroException;
import br.com.casacodig.model.Estado;
import br.com.casacodig.model.Pais;
import br.com.casacodig.services.EstadoServices;
import br.com.casacodig.services.LivroServices;

@RestController
public class EstadoController {

	@Autowired
	private EstadoServices estadoservice;
	
	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping(value = "/v1/estado")
	@Transactional
	public ResponseEntity<?> cria(@Valid @RequestBody EstadoDTO estadodto) {
		try {
			Estado estado = estadoservice.salvar(estadodto);
			//System.out.println("-------------PAIS CONTROLLER------------------");
			//System.out.println(pais.toString());
			manager.persist(estado);
			return new ResponseEntity<>(estado,HttpStatus.OK);
		} catch (Exception e) {
			throw new ApiErroException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
}
