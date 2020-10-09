package com.example.apicasadocodigo.fluxocompra.compra;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RestController
public class DetalhesCompraController {
    @PersistenceContext
    private EntityManager manager;

    @GetMapping("/compras/{id}")
    public ResponseEntity detalheCompra(@PathVariable Long id) {
        Compra compra = manager.find(Compra.class, id);
        CompraResponse response = new CompraResponse(compra);
        return ResponseEntity.ok(response);
    }
}