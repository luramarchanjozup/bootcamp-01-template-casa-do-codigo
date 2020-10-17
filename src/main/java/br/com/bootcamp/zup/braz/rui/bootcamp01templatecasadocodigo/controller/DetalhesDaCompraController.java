package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.controller;

import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.Compra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;

@RestController
@RequestMapping(value = "/detalheCompra")
public class DetalhesDaCompraController {

    @Autowired
    EntityManager entityManager;

//    @GetMapping(value = "/{idCompra}")
//    public EntityManager<?> detalheCompra(@PathVariable Integer idCompra){
//
//        return ResponseEntity.notFound().build();
//    }
}
