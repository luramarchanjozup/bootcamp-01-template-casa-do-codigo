package br.com.zup.treinocasadocodigo.controllers;

import br.com.zup.treinocasadocodigo.entities.Estado;
import br.com.zup.treinocasadocodigo.entities.EstadoNovoRequest;
import br.com.zup.treinocasadocodigo.entities.Pais;
import br.com.zup.treinocasadocodigo.entities.PaisNovoRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class PaisController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping("/paises")
    @Transactional
    public String cadastroPais(@RequestBody @Valid PaisNovoRequest novoPais) {
        //1
        Pais pais = novoPais.toModel();
        manager.persist(pais);
        return pais.toString();
    }
}
