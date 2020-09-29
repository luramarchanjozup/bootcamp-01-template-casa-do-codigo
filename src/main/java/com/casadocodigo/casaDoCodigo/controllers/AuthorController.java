package com.casadocodigo.casaDoCodigo.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Email;

import com.casadocodigo.casaDoCodigo.services.CheckDuplicatedEmail;
import com.casadocodigo.casaDoCodigo.controllers.form.AuthorForm;
import com.casadocodigo.casaDoCodigo.model.Author;
import com.casadocodigo.casaDoCodigo.services.AuthorServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
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
    @Autowired
    private CheckDuplicatedEmail checkDuplicatedEmail;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(checkDuplicatedEmail);
    }

    @GetMapping("/{email}")
    public ResponseEntity<Author> detailedIndex(@PathVariable @Email String email) {
        Optional<Author> author = authorServices.detailedIndex(email);
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
