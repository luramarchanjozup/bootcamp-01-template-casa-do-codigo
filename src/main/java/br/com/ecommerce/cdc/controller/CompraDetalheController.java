package br.com.ecommerce.cdc.controller;

import br.com.ecommerce.cdc.domain.model.Compra;
import br.com.ecommerce.cdc.domain.model.CompraDetalhe;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Carga intrínseca máxima permitida - 7
 * Carga intrínseca da classe - 2
 */

@RestController
@RequestMapping("/v2/compra")
public class CompraDetalheController {

    @PersistenceContext
    private EntityManager manager;

    @GetMapping("/{id}")
    public ResponseEntity<?> compraDetalhe(@PathVariable Long id){
        // +1
        Compra compra = manager.find(Compra.class, id);
        // +1
        CompraDetalhe compraDetalhe = new CompraDetalhe(compra);

        return ResponseEntity.ok().body(compraDetalhe);
    }
}
