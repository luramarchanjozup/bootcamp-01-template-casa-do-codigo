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

//Complexidade = 3
//Estado, estadoRequest, if

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> criarEstado(@Valid @RequestBody EstadoRequest estadoRequest) throws Exception {

        Estado estado = estadoRequest.toModel(manager);

        if (estado.getPais() == null) {
            throw new Exception("Estado não pode ser cadastrado. País não encontrado.");
        }

        manager.persist(estado);

        return ResponseEntity.ok().build();
    }

}
