package br.com.casadocodigo.controller;

import br.com.casadocodigo.model.Categoria;
import br.com.casadocodigo.model.NovaCategoriaRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;


@RestController
public class CadastraCategoriaController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/api/categoria")
    @Transactional
    public String criaCategoria(@Valid @RequestBody NovaCategoriaRequest novaCategoriaRequest) {
        Categoria novaCategoria = novaCategoriaRequest.toCategoria();
        entityManager.persist(novaCategoria);
        return novaCategoria.toString();
    }

}
