package br.com.casacodig.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.casacodig.dto.EstadoDTO;
import br.com.casacodig.model.Estado;
import br.com.casacodig.services.EstadoServices;

//Contagem de Pontos - TOTAL:3
//1 - EstadoServices
//1 - EstadoDTO
//1 - Estado

@RestController
public class EstadoController {

	@Autowired
	private EstadoServices estadoservice;
	
	@PostMapping(value = "/v1/estado")
	@Transactional
	public ResponseEntity<?> cria(@Valid @RequestBody EstadoDTO estadodto) {
		Estado estado = estadoservice.salvar(estadodto);
		return new ResponseEntity<>(estado,HttpStatus.OK);
	}
}
