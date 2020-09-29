package com.casadocodigo.casadocodigo.Categoria;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoriasController {

	@PersistenceContext
	private EntityManager manager;

	@Transactional
	@PostMapping("/categorias")
	public String cadastraCategoria(@RequestBody @Valid CategoriaDto dto) {

		Categoria novaCategoria = dto.toModel();
		manager.persist(novaCategoria);
		return novaCategoria.toString();

	}

}
