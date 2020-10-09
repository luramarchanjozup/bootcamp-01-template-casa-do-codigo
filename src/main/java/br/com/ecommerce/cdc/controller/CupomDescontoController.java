package br.com.ecommerce.cdc.controller;

import br.com.ecommerce.cdc.domain.model.CupomDesconto;
import br.com.ecommerce.cdc.domain.request.CupomDescontoRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/v2/cupom")
public class CupomDescontoController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<?> criaCupomDesconto(@RequestBody @Validated CupomDescontoRequest cupomDescontoRequest) throws URISyntaxException {

        CupomDesconto cupomDesconto = cupomDescontoRequest.toModel();
        manager.persist(cupomDesconto);
        return ResponseEntity.created(new URI("/cupom/")).build();

    }
}
