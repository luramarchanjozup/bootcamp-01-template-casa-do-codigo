package com.casadocodigo.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import com.casadocodigo.responses.BookDetailResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.casadocodigo.entity.Book;
import com.casadocodigo.requests.BookRequest;
import com.google.gson.Gson;

@RestController
@RequestMapping("/api/book")
public class BookController {

	@PersistenceContext
	private EntityManager manager;

	@PostMapping(value = "")
	@Transactional
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> save(@Valid @RequestBody BookRequest request) {

		Book book = request.toModel(manager);
		manager.persist(book);
		BookDetailResponse response = new BookDetailResponse(book);

		return ResponseEntity.ok(response);
	}

}
