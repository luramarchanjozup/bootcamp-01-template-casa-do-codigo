package br.com.ecommerce.cdc.controller;

import br.com.ecommerce.cdc.domain.model.Estado;
import br.com.ecommerce.cdc.domain.request.EstadoRequest;
import br.com.ecommerce.cdc.domain.response.EstadoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Carga intrínseca máxima permitida - 7
 * Carga intrínseca da classe - 3
 */

@RestController
@RequestMapping("/v2/estado")
public class EstadoController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    // +1
    public ResponseEntity<?> criaEstado(@RequestBody @Validated EstadoRequest estadoRequest){

        // +1
        Estado estado = estadoRequest.toModel(manager);
        manager.persist(estado);
        // +1
        EstadoResponse estadoResponse = new EstadoResponse(estado);

        return ResponseEntity.ok().body(estadoResponse);
    }

}
