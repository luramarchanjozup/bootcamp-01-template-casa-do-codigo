package com.example.apicasadocodigo.localidade;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/estados")
public class EstadoController {
    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public String criarEstado(@Valid @RequestBody NovoEstadoRequest request) {
        Estado novoEstado = request.toModel(manager);
        manager.persist(novoEstado);
        return "O estado " + novoEstado.getNome() + " foi cadastrado.";
    }
}
