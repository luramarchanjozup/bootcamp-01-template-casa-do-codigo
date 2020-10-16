package com.cdcAPI.api.controller;

import com.cdcAPI.api.model.Request.CategoriaRequest;
import com.cdcAPI.model.Categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

//Complexidade
//CategoriaRequest, Categoria
//Total = 3

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> criarCategoria(@Valid @RequestBody CategoriaRequest categoriaRequest) {
        Categoria categoria = categoriaRequest.toModel();
        manager.persist(categoria);

        return ResponseEntity.ok().build();
    }
}
