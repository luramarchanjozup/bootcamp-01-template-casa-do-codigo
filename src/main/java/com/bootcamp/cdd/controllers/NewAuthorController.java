package com.bootcamp.cdd.controllers;

import com.bootcamp.cdd.models.Author;
import com.bootcamp.cdd.models.AuthorRequest;
import com.bootcamp.cdd.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/author")
public class NewAuthorController {
    @PersistenceContext
    private EntityManager entityManager;
    private final AuthorRepository authorRepository;

    @Autowired
    public NewAuthorController (AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<String> createAuthor (@RequestBody @Valid AuthorRequest request) {
        Optional<Author> emailExists = this.authorRepository.findByEmail(request.getEmail());
        if (emailExists.isPresent()) {
            return ResponseEntity.status(409).body("Email is already in use!");
        }
        Author author = new Author(request.getName(), request.getEmail(), Instant.now());
        entityManager.persist(author);
        return ResponseEntity.status(201).body(author.toString());
    }
}
