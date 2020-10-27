package com.casadocodigo.casadocodigo.Autor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutoresController {

	@PersistenceContext
	private EntityManager manager;

	@Transactional
	@PostMapping("/autores")
	public String cadastraAutor(@RequestBody @Valid AutorDto dto) {
		Autor novoAutor = dto.toModel();
		manager.persist(novoAutor);
		return novoAutor.toString();
	}
}
