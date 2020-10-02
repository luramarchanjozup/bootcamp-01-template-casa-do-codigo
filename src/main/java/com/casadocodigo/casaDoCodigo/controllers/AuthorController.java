package com.casadocodigo.casaDoCodigo.controllers;

import javax.validation.Valid;
import javax.validation.constraints.Email;

import com.casadocodigo.casaDoCodigo.services.validators.CheckDuplicatedEmail;
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
        return ResponseEntity.ok().body(authorServices.detailedIndex(email));
    }

    @PostMapping
    public ResponseEntity<DetailedAuthorDto> createAuthor(@RequestBody @Valid AuthorForm form) {
        return ResponseEntity.ok().body(authorServices.createAuthor(form));
    }
}
