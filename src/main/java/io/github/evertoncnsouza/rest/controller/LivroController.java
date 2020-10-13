package io.github.evertoncnsouza.rest.controller;

import io.github.evertoncnsouza.domain.entity.Livro;
import io.github.evertoncnsouza.rest.dto.LivroRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

//2 PCI's;
@RestController
@RequestMapping("api/livros")
public class LivroController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    //@ResponseStatus(HttpStatus.CREATED) Comentado para retornar 200;
    public String save(@RequestBody @Valid LivroRequest request) {
        Livro livro = request.toModel(manager);
        manager.persist(livro);
        return livro.toString();
    }
//LivroRequest PCI 1;
//Livro PCI 2;
}

