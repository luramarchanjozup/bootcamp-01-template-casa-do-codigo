package br.com.casadocodigo.controllers;

import br.com.casadocodigo.models.Author;
import br.com.casadocodigo.repositories.AuthorRepository;
import br.com.casadocodigo.services.UniqueService;
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

    @Autowired
    private UniqueService uniqueService;

    public ResponseEntity<Author> createAuthor(@RequestBody @Valid Author author){

        boolean uniqueEmail = uniqueService.isUnique(author.getEmail());

        if(author != null && uniqueEmail){
            authorRepository.save(author);
            return ResponseEntity.ok(author);
        }

        return ResponseEntity.notFound().build();

    }

}
