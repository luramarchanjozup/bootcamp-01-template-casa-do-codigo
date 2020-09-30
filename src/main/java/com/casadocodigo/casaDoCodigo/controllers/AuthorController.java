package com.casadocodigo.casaDoCodigo.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;

import com.casadocodigo.casaDoCodigo.services.validators.CheckDuplicatedEmail;
import com.casadocodigo.casaDoCodigo.controllers.dto.AuthorDto;
import com.casadocodigo.casaDoCodigo.controllers.dto.DetailedAuthorDto;
import com.casadocodigo.casaDoCodigo.controllers.form.AuthorForm;
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
    public ResponseEntity<DetailedAuthorDto> detailedIndex(@PathVariable @Email String email) {
        DetailedAuthorDto author = authorServices.detailedIndex(email);
        return ResponseEntity.ok().body(author);
    }

    @GetMapping
    public ResponseEntity<List<AuthorDto>> index() {
        List<AuthorDto> authors = authorServices.index();
        return ResponseEntity.ok().body(authors);
    }

    @PostMapping
    public ResponseEntity<DetailedAuthorDto> createAuthor(@RequestBody @Valid AuthorForm form, UriComponentsBuilder uriBuilder) {
        DetailedAuthorDto author = authorServices.createAuthor(form);
        URI uri = uriBuilder.path("author/{id}").buildAndExpand(author.getId()).toUri();
        return ResponseEntity.created(uri).body(author);
    }
}
