package br.com.treino.casadocodigo.controller;

import br.com.treino.casadocodigo.model.Compra;
import br.com.treino.casadocodigo.request.NovaCompraRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
public class CompraController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping(value = "/compra")
    public ResponseEntity novoCliente(@RequestBody @Valid NovaCompraRequest request) {
        Compra compra = request.toModel(entityManager);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
