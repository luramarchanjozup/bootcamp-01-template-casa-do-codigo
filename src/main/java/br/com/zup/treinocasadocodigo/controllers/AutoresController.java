package br.com.zup.treinocasadocodigo.controllers;

import br.com.zup.treinocasadocodigo.entities.autor.Autor;
import br.com.zup.treinocasadocodigo.entities.autor.AutorNovoRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

/**
 * Contagem de carga intrínseca da classe: 2
 */

@RestController
@RequestMapping("/autores")
public class AutoresController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    //1
    public String cadastroAutor(@RequestBody @Valid AutorNovoRequest novoAutor) {

        //1
        Autor autor = novoAutor.toModel();
        manager.persist(autor);
        return autor.toString();
    }
}
