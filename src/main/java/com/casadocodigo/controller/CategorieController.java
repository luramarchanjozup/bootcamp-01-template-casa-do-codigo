package com.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import com.casadocodigo.responses.CategoryBookResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.casadocodigo.entity.Categories;
import com.casadocodigo.requests.CategoriesRequest;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/category")
public class CategorieController {

	@PersistenceContext
	private EntityManager manager;

	@PostMapping(value = "")
	@Transactional
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> save(@Valid @RequestBody CategoriesRequest request, UriComponentsBuilder uriComponentsBuilder) {

		Categories category = new Categories(request.getName());
		manager.persist(category);

		return ResponseEntity.created(uriComponentsBuilder.path("/api/category/{id}")
				.buildAndExpand(category.getId()).toUri()).build();
	}

}
