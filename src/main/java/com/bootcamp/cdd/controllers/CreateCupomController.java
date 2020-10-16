package com.bootcamp.cdd.controllers;

import com.bootcamp.cdd.models.Cupom;
import com.bootcamp.cdd.request.CupomRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/cupom")
public class CreateCupomController {
    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public Cupom createCupom (@Valid @RequestBody CupomRequest request) {
        Cupom cupom = request.toModel();
        manager.persist(cupom);
        return cupom;
    }
}
