package com.example.apicasadocodigo.novoautor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {
    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public String novoAutor(@RequestBody @Valid NovoAutorRequest request) {
        Autor autor = request.toModel();
        manager.persist(autor);
        return "Novo autor criado.";
    }

    @GetMapping
    public String ola() {
        return "Hello World";
    }
}