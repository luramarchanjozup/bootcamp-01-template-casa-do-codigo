package br.com.casacodig.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

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
//1 - 

@RestController
public class AutorController {
	
	@Autowired
	private AutorServices autorService;
	
	@PersistenceContext
	private EntityManager manager;

	@PostMapping("/v1/autor")
	@Transactional
	//public ResponseEntity<?> cadastrarAutor(@Valid @RequestBody AutorDTO autordto, BindingResult result){
	public String cadastrarAutor(@Valid @RequestBody AutorDTO autordto, BindingResult result){
		try {
			autorService.validarEmail(autordto);
			Autor autor = autorService.salvar(autordto);
			manager.persist(autor);
			return autor.toString();
		} catch (Exception e) {
			throw new ApiErroException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@GetMapping("/teste")
	public String teste(){
		return "Teste";
	}
}