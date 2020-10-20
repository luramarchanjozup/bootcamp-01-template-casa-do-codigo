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
import java.util.Optional;

@RequestMapping("comprafeita")
@RestController
public class DetalheCompraController {

    @PersistenceContext
    private EntityManager manager;

    @GetMapping("{id}")
    public ResponseEntity<DetalheCompraResponse> getMethodName(@PathVariable("id") Long idCompra) {
        Optional<Compra> possivelCompra = Optional.ofNullable(manager.find(Compra.class, idCompra));
        Optional<DetalheCompraResponse> possivelDetalheCompra = possivelCompra.map(compra -> new DetalheCompraResponse(compra));
        return ResponseEntity.of(possivelDetalheCompra);
    }
}