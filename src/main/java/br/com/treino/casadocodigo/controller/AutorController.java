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
@RequestMapping(value = "/autores")
public class AutorController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity novoAutor(@RequestBody @Valid NovoAutorRequest request){ //1
        Autor novoautor = request.toModel(); //2
        entityManager.persist(novoautor);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
