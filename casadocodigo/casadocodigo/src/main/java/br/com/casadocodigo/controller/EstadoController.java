package br.com.casadocodigo.controller;

import br.com.casadocodigo.model.Estado;
import br.com.casadocodigo.model.NovoEstadoRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class EstadoController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/api/estados")
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public String criaEstado(@Valid @RequestBody NovoEstadoRequest novoEstadoRequest){
        Estado novoEstado = novoEstadoRequest.toEstado(entityManager);
        entityManager.persist(novoEstado);
        return novoEstado.toString();
    }
}
