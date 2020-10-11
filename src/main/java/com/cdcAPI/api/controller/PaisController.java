package com.cdcAPI.api.controller;

import com.cdcAPI.api.model.Request.PaisRequest;
import com.cdcAPI.model.Pais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

//Complexidade = 2
//Pais, PaisRequest

@RestController
@RequestMapping("/paises")
public class PaisController {

    @Autowired
    EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> criarPais(@Valid @RequestBody PaisRequest paisRequest) {
        Pais pais = paisRequest.toModel();
        manager.persist(pais);

        return ResponseEntity.ok().build();
    }

//    @GetMapping
//    public ResponseEntity<List<Pais>> getPais() {
//        List<Pais> list = paisRepository.findAll();
//        return ResponseEntity.ok(list);
//    } Não necessário
}
