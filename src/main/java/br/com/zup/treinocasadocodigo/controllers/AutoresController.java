package br.com.zup.treinocasadocodigo.controllers;

import br.com.zup.treinocasadocodigo.entities.Autor;
import br.com.zup.treinocasadocodigo.entities.AutorNovoRequest;
import br.com.zup.treinocasadocodigo.validators.AutorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

/**
 * Contagem de carga intrínseca da classe: 3
 */

@RestController
public class AutoresController {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    //1
    private AutorValidator autorValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(autorValidator);
    }

    @PostMapping(value="/autores")
    @Transactional
    //1
    public String cadastroAutor(@RequestBody @Valid AutorNovoRequest novoAutor) {

        //1
        Autor autor = novoAutor.toModel();
        manager.persist(autor);
        return autor.toString();
    }
}
