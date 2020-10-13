package com.casadocodigo.controller;

import com.casadocodigo.entity.Book;
import com.casadocodigo.requests.BookRequest;
import com.casadocodigo.responses.BookDetailResponse;
import com.casadocodigo.responses.BooksResponse;
import com.casadocodigo.responses.PurchaseDetailResponse;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookDetailController {

	@PersistenceContext
	private EntityManager manager;

	@GetMapping(value = "/books")
	public ResponseEntity<?> list() {
		List<?> books = manager.createQuery("select b from Book b").getResultList();

		BooksResponse response = new BooksResponse(books);
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> details( @PathVariable(value = "id") Long id) {
		Book book =  manager.find(Book.class, id );
		
		if(book == null) {
			return ResponseEntity.notFound().build();
		}

		BookDetailResponse response = new BookDetailResponse(book);
		
		return ResponseEntity.ok(response);
	}

}
