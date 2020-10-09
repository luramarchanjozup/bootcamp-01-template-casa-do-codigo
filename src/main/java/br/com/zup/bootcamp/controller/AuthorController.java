package br.com.zup.bootcamp.controller;

import br.com.zup.bootcamp.controller.model.AuthorRequest;
import br.com.zup.bootcamp.controller.model.GenericResponse;
import br.com.zup.bootcamp.domain.model.Author;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

// Intrinsic charge = 3
@RestController
@RequestMapping("/author")
public class AuthorController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<GenericResponse> register(@Validated @RequestBody AuthorRequest request) {
        Author newAuthor = request.convert();
        manager.persist(newAuthor);

        GenericResponse response = new GenericResponse("The author was registered");
        return new ResponseEntity<GenericResponse>(response, HttpStatus.OK);
    }
}
