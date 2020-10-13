package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.controller;

import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.Compra;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.requests.NovaCompraRequest;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.validation.PaisComEstadoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;

@RestController
@RequestMapping(value = "/novaCompra")
public class NovaCompraController {

    @Autowired
    EntityManager entityManager;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(new PaisComEstadoValidator());
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Compra> novaCompra(@Validated @RequestBody NovaCompraRequest novaCompraRequest){
        Compra novaCompra = novaCompraRequest.toModel(entityManager);
        entityManager.persist(novaCompra);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaCompra);
    }
}
