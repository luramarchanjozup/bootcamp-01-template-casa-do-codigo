package br.com.zup.bootcamp.controller;

import br.com.zup.bootcamp.controller.model.AuthorRequest;
import br.com.zup.bootcamp.controller.model.GenericResponse;
import br.com.zup.bootcamp.database.model.Author;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<GenericResponse> register(@Valid @RequestBody AuthorRequest request){
        Author newAuthor = request.convert();
        manager.persist(newAuthor);
        GenericResponse response = new GenericResponse("The author was registered!", 200);
        return new ResponseEntity<GenericResponse>(response, HttpStatus.CREATED);
    }
}
