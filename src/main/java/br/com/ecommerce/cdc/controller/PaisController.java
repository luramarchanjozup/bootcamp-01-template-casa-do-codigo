package br.com.ecommerce.cdc.controller;

import br.com.ecommerce.cdc.domain.model.Pais;
import br.com.ecommerce.cdc.domain.request.PaisRequest;
import br.com.ecommerce.cdc.domain.response.PaisResponse;
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
@RequestMapping("/v2/pais")
public class PaisController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    // +1
    public ResponseEntity<?> criaPais(@RequestBody @Validated PaisRequest paisRequest){
        // +1
        Pais pais = paisRequest.toModel();
        manager.persist(pais);
        // +1
        PaisResponse paisResponse = new PaisResponse(pais);

        return ResponseEntity.ok().body(paisResponse);
    }
}
