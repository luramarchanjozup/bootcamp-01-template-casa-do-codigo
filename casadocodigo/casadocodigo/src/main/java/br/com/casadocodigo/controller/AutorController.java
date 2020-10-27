    package br.com.casadocodigo.controller;

import br.com.casadocodigo.model.Autor;
import br.com.casadocodigo.model.NovoAutorRequest;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class AutorController {

    @PersistenceContext
    private EntityManager entityManager;


    @PostMapping("/api/autor")
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public String criaAutor(@Valid @RequestBody NovoAutorRequest novoAutorRequest){
        Autor novoAutor = novoAutorRequest.toAutor();
        entityManager.persist(novoAutor);
        //autorRepository.save(novoAutorRequest.toAutor());
        return novoAutor.toString();
        //entityManager.persist(NovoAutorRequest);
    }
}
