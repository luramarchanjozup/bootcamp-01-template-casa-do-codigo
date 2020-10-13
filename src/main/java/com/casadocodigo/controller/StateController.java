package com.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import com.casadocodigo.responses.StateDetailResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.casadocodigo.entity.State;
import com.casadocodigo.requests.StateRequest;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/state")
public class StateController {

	@PersistenceContext
	private EntityManager manager;

	@PostMapping(value = "")
	@Transactional
	public ResponseEntity<?> save(@Valid @RequestBody StateRequest request, UriComponentsBuilder uriComponentsBuilder) {

		State state = request.toModel(manager);
		manager.persist(state);

		return ResponseEntity.created(uriComponentsBuilder.path("/api/state/{id}")
				.buildAndExpand(state.getId()).toUri()).build();
	}

}
