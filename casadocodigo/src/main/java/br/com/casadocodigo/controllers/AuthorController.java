package br.com.casadocodigo.controllers;

import br.com.casadocodigo.dtos.AuthorDto;
import br.com.casadocodigo.forms.AuthorForm;
import br.com.casadocodigo.models.Author;
import br.com.casadocodigo.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @PostMapping
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody @Valid AuthorForm authorForm){

        Author author = authorForm.toEntity();

        if(author != null){

            authorRepository.save(author);
            return ResponseEntity.ok(new AuthorDto(author));

        }

        return ResponseEntity.notFound().build();

    }
}
