package com.bootcamp.cdd.controllers;

import com.bootcamp.cdd.models.Book;
import com.bootcamp.cdd.request.BookRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/book")
public class BookController {
    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public Book createBook (@RequestBody @Valid BookRequest request) {
        Book book = request.toModel(entityManager);
        entityManager.persist(book);
        return book;
    }
}
