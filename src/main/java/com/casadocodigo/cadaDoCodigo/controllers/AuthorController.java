package com.casadocodigo.cadaDoCodigo.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.casadocodigo.cadaDoCodigo.controllers.form.AuthorForm;
import com.casadocodigo.cadaDoCodigo.model.Author;
import com.casadocodigo.cadaDoCodigo.services.AuthorServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/author")
public class AuthorController {
    
    @Autowired
    private AuthorServices authorServices;

    @GetMapping("/{id}")
    public ResponseEntity<Author> detailedIndex(@PathVariable Long id) {
        Optional<Author> author = authorServices.detailedIndex(id);
        return author.isPresent() ? ResponseEntity.ok(author.get()) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Author>> index() {
        List<Author> authors = authorServices.index();
        return ResponseEntity.ok(authors);
    }

    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody @Valid AuthorForm form, UriComponentsBuilder uriBuilder) {
        Author author = authorServices.createAuthor(form);
        URI uri = uriBuilder.path("author/{id}").buildAndExpand(author.getId()).toUri();
        return ResponseEntity.created(uri).body(author);
    }
}
