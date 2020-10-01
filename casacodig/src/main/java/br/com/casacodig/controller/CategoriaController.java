package br.com.casacodig.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.casacodig.dto.CategoriaDTO;
import br.com.casacodig.error.ApiErroException;
import br.com.casacodig.model.Categoria;
import br.com.casacodig.services.CategoriaServices;


//Contagem de Pontos - TOTAL:3
//1 - CategoriaServices
//1 - CategoriaDTO
//1 - Categoria

@RestController
public class CategoriaController {

	@Autowired
	private CategoriaServices categoriaservice;
	
	@PersistenceContext
	private EntityManager manager;

	@PostMapping(value = "/v1/categoria")
	@Transactional
	public String cria(@Valid @RequestBody CategoriaDTO categoriadto, BindingResult result) {
		try {
			Categoria categoria = categoriaservice.salvar(categoriadto);
			manager.persist(categoria);
			return categoria.toString();
		} catch (Exception e) {
			throw new ApiErroException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@GetMapping("/v1/testecategoria")
	public String teste(){
		return "Teste Categoria";
	}
}
