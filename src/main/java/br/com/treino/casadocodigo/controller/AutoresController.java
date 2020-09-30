package br.com.treino.casadocodigo.controller;

import br.com.treino.casadocodigo.errors.Resultado;
import br.com.treino.casadocodigo.model.Autor;
import br.com.treino.casadocodigo.model.NovoAutorRequest;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class AutoresController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping(value = "/autores")
    @Transactional
    public String novoAutor(@RequestBody @Valid NovoAutorRequest request){
        Autor autor = request.toModel();
        entityManager.persist(autor);
        return autor.toString();
    }


}
