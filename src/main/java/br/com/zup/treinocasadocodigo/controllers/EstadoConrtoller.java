package br.com.zup.treinocasadocodigo.controllers;

import br.com.zup.treinocasadocodigo.entities.Estado;
import br.com.zup.treinocasadocodigo.entities.EstadoNovoRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class EstadoConrtoller {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping("/estados")
    @Transactional
    public String cadastroEstado(@RequestBody @Valid EstadoNovoRequest novoEstado) {
        //1
        Estado estado = novoEstado.toModel(manager);
        manager.persist(estado);
        return estado.toString();
    }
}
