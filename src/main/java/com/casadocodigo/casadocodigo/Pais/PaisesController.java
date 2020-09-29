package com.casadocodigo.casadocodigo.Pais;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaisesController {

	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping("/paises")
	@Transactional
	public String cadastraPais(@RequestBody @Valid PaisDto dto) {
		Pais novoPais = dto.toModel();
		manager.persist(novoPais);
		return novoPais.toString();
	}
	
}
