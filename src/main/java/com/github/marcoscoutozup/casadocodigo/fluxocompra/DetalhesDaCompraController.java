package com.github.marcoscoutozup.casadocodigo.fluxocompra;

import com.github.marcoscoutozup.casadocodigo.fluxocompra.compra.Compra;
import com.github.marcoscoutozup.casadocodigo.fluxocompra.compra.CompraResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.UUID;

@RestController
@RequestMapping("/compra")
public class DetalhesDaCompraController {

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/{id}")
    public ResponseEntity exibirDetalhesDaCompra(@PathVariable UUID id){
        //1
        Compra compra = entityManager.find(Compra.class, id);

        //2
        if(compra == null){
            return ResponseEntity.status(404).body("Compra não encontrada");
        }

        CompraResponse response = new CompraResponse(compra);
        return ResponseEntity.ok(response);
    }

}
