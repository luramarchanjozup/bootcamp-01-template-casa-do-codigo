package br.com.treino.casadocodigo.controller;

import br.com.treino.casadocodigo.model.Autor;
import br.com.treino.casadocodigo.request.NovoAutorRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class AutorController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping(value = "/autores")
    @Transactional
    public ResponseEntity novoAutor(@RequestBody @Valid NovoAutorRequest request){ //1
        Autor autor = request.toModel(); //2
        entityManager.persist(autor);
        return new ResponseEntity(HttpStatus.OK);
    }


}
