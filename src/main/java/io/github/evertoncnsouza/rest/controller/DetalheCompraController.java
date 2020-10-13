package io.github.evertoncnsouza.rest.controller;

import io.github.evertoncnsouza.domain.entity.Compra;
import io.github.evertoncnsouza.rest.dto.DetalheCompraResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RequestMapping("comprafeita")
@RestController
public class DetalheCompraController {

    @PersistenceContext
    private EntityManager manager;

@GetMapping("{id}")
public ResponseEntity<?> detalhe(@PathVariable("id") Long id){
    Compra comprabuscada = manager.find(Compra.class, id);
    if(comprabuscada ==null){
        return ResponseEntity.notFound().build();
    }
    DetalheCompraResponse detalheCompraResponse = new DetalheCompraResponse(
            comprabuscada);
    return ResponseEntity.ok (detalheCompraResponse);

}
}
