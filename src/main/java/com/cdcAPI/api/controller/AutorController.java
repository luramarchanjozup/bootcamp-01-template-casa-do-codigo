package com.cdcAPI.api.controller;

import com.cdcAPI.api.model.Request.AutorRequest;
import com.cdcAPI.model.Autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

//Complexidade = 2
//AutorRequest, Autor

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> criarAutor(@Valid @RequestBody AutorRequest autorRequest) {
        Autor autor = autorRequest.toModel();
        manager.persist(autor);

        return ResponseEntity.ok().build();
    }
}
