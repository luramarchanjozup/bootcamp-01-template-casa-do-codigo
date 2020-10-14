package br.com.casacodig.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.casacodig.dto.AutorDTO;
import br.com.casacodig.model.Autor;
import br.com.casacodig.services.AutorServices;


//Contagem de Pontos - TOTAL:3
//1 - AutorServices
//1 - AutorDTO
//1 - Autor


@RestController
public class AutorController {
	
	@Autowired
	private AutorServices autorService;
	

	@PostMapping(value = "/v1/autor", produces = "application/json")
	@Transactional
	public ResponseEntity<?> cadastrarAutor(@Valid @RequestBody AutorDTO autordto){
		Autor autor = autorService.salvar(autordto);
		return new ResponseEntity<>(autor,HttpStatus.OK);
	}
}