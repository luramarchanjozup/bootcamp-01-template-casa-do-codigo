package com.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import com.casadocodigo.responses.CountryDetailResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.casadocodigo.entity.Country;
import com.casadocodigo.requests.CountryRequest;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/country")
public class CountryController {

	@PersistenceContext
	private EntityManager manager;

	@PostMapping(value = "")
	@Transactional
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> save(@Valid @RequestBody CountryRequest request, UriComponentsBuilder uriComponentsBuilder) {

		Country country = new Country(request.getName());
		manager.persist(country);

		return ResponseEntity.created(uriComponentsBuilder.path("/api/country/{id}")
				.buildAndExpand(country.getId()).toUri()).build();
	}

}
