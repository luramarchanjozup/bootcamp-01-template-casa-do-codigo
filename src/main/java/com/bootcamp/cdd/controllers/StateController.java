package com.bootcamp.cdd.controllers;

import com.bootcamp.cdd.models.State;
import com.bootcamp.cdd.request.StateRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/state")
public class StateController {
    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public State createState (@Valid @RequestBody StateRequest request) {
        State state = request.toModel(manager);
        manager.persist(state);
        return state;
    }

}
