package com.bootcamp.cdd.controllers;

import com.bootcamp.cdd.models.Author;
import com.bootcamp.cdd.request.AuthorRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/author")
public class NewAuthorController {
    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public Author createAuthor (@RequestBody @Valid AuthorRequest request) {
        Author author = request.toModel();
        entityManager.persist(author);
        return author;
    }
}
