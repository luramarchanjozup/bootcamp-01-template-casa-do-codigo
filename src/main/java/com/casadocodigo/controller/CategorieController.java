package com.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.casadocodigo.entity.Categories;
import com.casadocodigo.requests.CategoriesRequest;

@RestController
@RequestMapping("/api/categories")
public class CategorieController {

	@PersistenceContext
	private EntityManager manager;

	@PostMapping(value = "")
	@Transactional
	@ResponseStatus(HttpStatus.CREATED)
	public String save(@Valid @RequestBody CategoriesRequest request) {

		Categories categorie = new Categories(request.getName());
		manager.persist(categorie);
		return categorie.toString();
	}

}
