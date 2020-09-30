package br.com.zup.bootcamp.controller;

import br.com.zup.bootcamp.controller.model.AuthorRequest;
import br.com.zup.bootcamp.controller.model.GenericResponse;
import br.com.zup.bootcamp.database.model.Author;
import br.com.zup.bootcamp.database.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

// Intrinsic charge = 4
@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorRepository repository;

    @PostMapping
    public ResponseEntity<GenericResponse> register(@Valid @RequestBody AuthorRequest request) {
        GenericResponse response;

        if(repository.findByEmail(request.getEmail()).isPresent()){
            response = new GenericResponse("Author's email already registered");
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(response);
        }

        Author newAuthor = request.convert();
        repository.save(newAuthor);

        response = new GenericResponse("The author was registered");
        return new ResponseEntity<GenericResponse>(response, HttpStatus.CREATED);
    }
}
