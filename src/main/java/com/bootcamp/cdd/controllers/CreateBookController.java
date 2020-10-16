package com.bootcamp.cdd.controllers;

import com.bootcamp.cdd.models.Book;
import com.bootcamp.cdd.request.BookRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/book")
public class CreateBookController {
    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public Book createBook (@RequestBody @Valid BookRequest request) {
        Book book = request.toModel(entityManager);
        entityManager.persist(book);
        return book;
    }
}
