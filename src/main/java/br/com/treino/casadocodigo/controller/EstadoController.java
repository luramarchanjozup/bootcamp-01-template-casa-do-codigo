package br.com.treino.casadocodigo.controller;

import br.com.treino.casadocodigo.model.Estado;
import br.com.treino.casadocodigo.request.NovoEstadoRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class EstadoController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping(value = "/estados")
    @Transactional
    public ResponseEntity<Estado> novoEstado(@RequestBody @Valid NovoEstadoRequest request){ //1
        Estado estado = request.toModel(entityManager); //2
        entityManager.persist(estado);
        return new ResponseEntity(HttpStatus.OK);
    }
}
