package com.bootcamp.cdd.controllers;

import com.bootcamp.cdd.models.Author;
import com.bootcamp.cdd.models.AuthorRequest;
import com.bootcamp.cdd.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/author")
public class NewAuthorController {
    private AuthorRepository authorRepository;

    @Autowired
    public NewAuthorController (AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @PostMapping
    public Author createAuthor (@RequestBody @Valid AuthorRequest request) {
        Optional<Author> emailExists = this.authorRepository.findByEmail(request.getEmail());
        if (emailExists.isPresent()) {
            Assert.notNull(emailExists, "email already exists");
        }
        Author author = new Author(request.getName(), request.getEmail(), Instant.now());
        this.authorRepository.save(author);
        return author;
    }
}
