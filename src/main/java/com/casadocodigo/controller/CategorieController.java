package com.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casadocodigo.entity.Categories;
import com.casadocodigo.requests.CategoriesRequest;
import com.casadocodigo.validators.CategoriesUniqueValidator;

@RestController
@RequestMapping("/api/categories")
public class CategorieController {

	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private CategoriesUniqueValidator categorieUniqueValidator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(categorieUniqueValidator);
	}
	
	@PostMapping(value = "")
	@Transactional
	public String save(@Valid @RequestBody CategoriesRequest request) {

		Categories categorie = new Categories(request.getName());
		manager.persist(categorie);
		return categorie.toString();
	}

}
