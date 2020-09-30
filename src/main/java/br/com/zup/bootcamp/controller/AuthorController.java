package br.com.zup.bootcamp.controller;

import br.com.zup.bootcamp.controller.exception.EmailAlreadyExistException;
import br.com.zup.bootcamp.controller.model.AuthorRequest;
import br.com.zup.bootcamp.controller.model.GenericResponse;
import br.com.zup.bootcamp.database.model.Author;
import br.com.zup.bootcamp.database.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;


// Intrinsic charge = 6
@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorRepository repository;

    @PostMapping
    public ResponseEntity<GenericResponse> register(@Valid @RequestBody AuthorRequest request) throws EmailAlreadyExistException {
        if(repository.findByEmail(request.getEmail()).isPresent())
            throw new EmailAlreadyExistException("Email already exist");

        Author newAuthor = request.convert();
        repository.save(newAuthor);

        GenericResponse response = new GenericResponse("The author was registered", 200);
        return new ResponseEntity<GenericResponse>(response, HttpStatus.CREATED);
    }
}
