package br.com.ecommerce.cdc.controller;

import br.com.ecommerce.cdc.domain.model.CupomDesconto;
import br.com.ecommerce.cdc.domain.request.CupomDescontoRequest;
import br.com.ecommerce.cdc.domain.response.CupomDescontoResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Carga Intrínseca máxima permitida - 7
 * Carga Intrínseca da classe - 3
 * */

@RestController
@RequestMapping("/v2/cupom")
public class CupomDescontoController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    // +1
    public ResponseEntity<?> criaCupomDesconto(@RequestBody @Validated CupomDescontoRequest cupomDescontoRequest) throws URISyntaxException {
        // +1
        CupomDesconto cupomDesconto = cupomDescontoRequest.toModel();
        manager.persist(cupomDesconto);
        // +1
        CupomDescontoResponse cupomDescontoResponse = new CupomDescontoResponse(cupomDesconto);
        return ResponseEntity.created(new URI("/cupom/".concat(cupomDescontoResponse.getId().toString()))).body(cupomDesconto);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> alteraCupomDesconto(@PathVariable Long id, @RequestBody @Validated CupomDescontoRequest cupomDescontoRequest){

        CupomDesconto cupomDesconto = manager.find(CupomDesconto.class, id);
        CupomDesconto cupomDescontoAtualizado = cupomDescontoRequest.toModel();
        BeanUtils.copyProperties(cupomDescontoAtualizado,cupomDesconto,"id");
        CupomDesconto cupomDescontoAlterado = manager.merge(cupomDesconto);
        CupomDescontoResponse cupomDescontoResponse = new CupomDescontoResponse(cupomDescontoAlterado);
        return ResponseEntity.ok().body(cupomDescontoResponse);
    }
}
