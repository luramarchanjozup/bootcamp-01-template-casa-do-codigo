package com.guiferrini.CasaCodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guiferrini.CasaCodigo.model.FluxoPagto;
import com.guiferrini.CasaCodigo.model.FluxoPagtoDTO;

@RestController
@RequestMapping("/pagto")
public class FluxoPagtoController {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@PostMapping
	@Transactional
	public FluxoPagto cria(@Valid @RequestBody FluxoPagtoDTO fluxoPagtoDTO) {
		
		FluxoPagto obj = fluxoPagtoDTO.toModel(entityManager);
		entityManager.persist(obj);
		
		return obj;
	}
}
//validar Qdo não tem Estado, esta com erro - @IdUnico(FluxoPagto) esse é o erro, pois no 'body' está sem id - duvida: onde fazer esta validação?
//feito a classe, o DTO, efetuar o POST
//feito: postman e controller inicial com rota