package com.cdcAPI.api.controller;

import com.cdcAPI.api.model.Request.CompraRequest;
import com.cdcAPI.api.model.Response.CompraResponse;
import com.cdcAPI.model.Compra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> comprar(@Valid @RequestBody CompraRequest compraRequest) throws Exception {
        Compra compra = compraRequest.toModel(manager);
        manager.persist(compra);

        String urlCreated = "/compras/" + compra.getId();

        return ResponseEntity.created(URI.create(urlCreated)).build();
    }

    @GetMapping("/{compraId}")
    @Transactional
    public ResponseEntity<CompraResponse> detalhesCompra(@PathVariable Long compraId) throws Exception {
        Compra compra = manager.find(Compra.class, compraId);
        if (compra == null) throw new Exception("Compra não existe.");

        CompraResponse compraResponse = new CompraResponse(compra);

        return ResponseEntity.ok(compraResponse);
    }

}
