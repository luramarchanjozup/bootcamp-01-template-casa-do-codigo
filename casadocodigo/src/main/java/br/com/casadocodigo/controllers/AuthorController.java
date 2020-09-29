package br.com.casadocodigo.controllers;

import br.com.casadocodigo.models.Author;
import br.com.casadocodigo.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    public ResponseEntity<Author> createAuthor(@RequestBody @Valid Author author){

        if(author != null){
            authorRepository.save(author);
            return ResponseEntity.ok(author);
        }

        return ResponseEntity.notFound().build();

    }

}
