package com.casadocodigo.cadaDoCodigo.controllers;

import java.util.List;
import java.util.Optional;

import com.casadocodigo.cadaDoCodigo.model.Author;
import com.casadocodigo.cadaDoCodigo.repositories.AuthorRepositiory;
import com.casadocodigo.cadaDoCodigo.services.AuthorServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
