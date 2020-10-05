package com.bootcamp.cdd.controllers;

import com.bootcamp.cdd.models.Author;
import com.bootcamp.cdd.request.AuthorRequest;
import com.bootcamp.cdd.validators.DuplicatedEmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
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

    private final DuplicatedEmailValidator duplicatedEmailValidator;

    @Autowired
    public NewAuthorController (DuplicatedEmailValidator duplicatedEmailValidator){
        this.duplicatedEmailValidator = duplicatedEmailValidator;
    }

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(this.duplicatedEmailValidator);
    }


    @PostMapping
    @Transactional
    public Author createAuthor (@RequestBody @Valid AuthorRequest request) {
        Author author = request.toModel();
        entityManager.persist(author);
        return author;
    }
}
