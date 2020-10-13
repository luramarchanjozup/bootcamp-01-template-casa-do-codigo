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

@RestController
@RequestMapping("/api/state")
public class StateController {

	@PersistenceContext
	private EntityManager manager;

	@PostMapping(value = "")
	@Transactional
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> save(@Valid @RequestBody StateRequest request) {

		State state = request.toModel(manager);
		manager.persist(state);

		StateDetailResponse response = new StateDetailResponse(state);

		return ResponseEntity.ok(response);
	}

}
