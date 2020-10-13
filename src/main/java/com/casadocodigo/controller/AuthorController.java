package com.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import com.casadocodigo.responses.AuthorBookResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.casadocodigo.entity.Author;
import com.casadocodigo.requests.AuthorRequest;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

	@PersistenceContext
	private EntityManager manager;

	@PostMapping(value = "")
	@Transactional
	public ResponseEntity<?> save(@Valid @RequestBody AuthorRequest request, UriComponentsBuilder uriComponentsBuilder) {

		Author author = request.toModel();
		manager.persist(author);

		return ResponseEntity.created(uriComponentsBuilder.path("/api/author/{id}")
				.buildAndExpand(author.getId()).toUri()).build();
	}

}
