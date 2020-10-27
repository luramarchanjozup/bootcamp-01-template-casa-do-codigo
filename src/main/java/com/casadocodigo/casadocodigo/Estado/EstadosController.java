package com.casadocodigo.casadocodigo.Estado;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EstadosController {

	@PersistenceContext
	private EntityManager manager;

	@PostMapping("/estado")
	@Transactional
	public String cadastraEstado(@RequestBody @Valid EstadoDto dto) {
		Estado novoEstado = dto.toModel(manager);
		manager.persist(novoEstado);
		return novoEstado.toString();
	}

}
