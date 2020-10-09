package com.example.apicasadocodigo.autor;

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
    public String criarAutor(@Valid @RequestBody NovoAutorRequest request) {
        Autor novoAutor = request.toModel();
        manager.persist(novoAutor);
        return "Autor(a) de email " + novoAutor.getEmail() + " criado(a).";
    }
}