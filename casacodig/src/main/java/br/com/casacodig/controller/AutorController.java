package br.com.casacodig.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.casacodig.dto.AutorDTO;
import br.com.casacodig.error.ApiErroException;
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
	
	@PersistenceContext
	private EntityManager manager;

	@PostMapping(value = "/v1/autor", produces = "application/json")
	@Transactional
	public ResponseEntity<?> cadastrarAutor(@Valid @RequestBody AutorDTO autordto){
		try {
			Autor autor = autorService.salvar(autordto);
			manager.persist(autor);
			return new ResponseEntity<>(autor,HttpStatus.OK);
		} catch (Exception e) {
			throw new ApiErroException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
}