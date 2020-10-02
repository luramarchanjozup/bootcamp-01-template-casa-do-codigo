package br.com.zup.bootcamp.controller;

import br.com.zup.bootcamp.controller.model.GenericResponse;
import br.com.zup.bootcamp.controller.model.StateRequest;
import br.com.zup.bootcamp.domain.model.State;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

// Intrinsic charge = 3
@RestController
@RequestMapping("/state")
public class StateController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<GenericResponse> register(@Validated @RequestBody StateRequest request){
        State state = request.convert();
        manager.persist(state);

        GenericResponse response = new GenericResponse("State was registered");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
