package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.controller;

import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.Estado;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.requests.NovoEstadoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;

@RestController
@RequestMapping(value = "/novoEstado")
public class NovoEstadoController {

    @Autowired
    EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<Estado> novoEstado(@Validated @RequestBody NovoEstadoRequest novoEstadoRequest){

        Estado novoEstado = novoEstadoRequest.toModel(entityManager);
        entityManager.persist(novoEstado);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoEstado);
    }
}
