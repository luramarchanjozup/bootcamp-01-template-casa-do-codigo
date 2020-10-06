package br.com.casadocodigo.controllers;

import br.com.casadocodigo.dtos.AuthorDto;
import br.com.casadocodigo.forms.AuthorForm;
import br.com.casadocodigo.models.Author;
import br.com.casadocodigo.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.time.OffsetDateTime;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    // +1
    @Autowired
    private AuthorRepository authorRepository;

    @PostMapping                                                         // +1
    public ResponseEntity<?> createAuthor(@RequestBody @Valid AuthorForm authorForm){

            // +1
            Author author = authorForm.toEntity();

            // +1
            authorRepository.save(author);

            return ResponseEntity
                    .ok()
                    .build();

    }
}
