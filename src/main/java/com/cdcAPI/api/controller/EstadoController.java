package com.cdcAPI.api.controller;

import com.cdcAPI.api.model.Request.EstadoRequest;
import com.cdcAPI.model.Estado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

//Complexidade = 2
//Estado, estadoRequest

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EntityManager manager;

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> criarEstado(@Valid @RequestBody EstadoRequest estadoRequest) throws Exception {
        Estado estado = estadoRequest.toModel(manager);
        manager.persist(estado);

        return ResponseEntity.ok().build();
    }

}
