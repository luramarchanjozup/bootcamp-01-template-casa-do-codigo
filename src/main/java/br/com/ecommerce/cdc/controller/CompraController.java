package br.com.ecommerce.cdc.controller;

import br.com.ecommerce.cdc.domain.model.Compra;
import br.com.ecommerce.cdc.domain.request.CompraRequest;
import br.com.ecommerce.cdc.domain.response.CompraResponse;
import br.com.ecommerce.cdc.validation.EstadoPertecePaisValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Carga Intrínseca máxima permitida - 7
 * Carga Intrínseca da classe - 4
 *
 */
@RestController
@RequestMapping("/v2/compra")
public class CompraController {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    // +1
    private EstadoPertecePaisValidator estadoPertecePaisValidator;

    @InitBinder
    protected void initBinder(WebDataBinder webDataBinder){
        webDataBinder.addValidators(estadoPertecePaisValidator);
    }

    @PostMapping
    @Transactional
    // +1
    public ResponseEntity<?> criaCadastro(@RequestBody @Validated CompraRequest compraRequest) throws URISyntaxException {
        // +1
        Compra compra = compraRequest.toModel(manager);
        double valorTotal = compra.getValorTotal();
        Assert.isTrue(compraRequest.compraTotal() == valorTotal, "Valor total diferente do valor recebido.");
        manager.persist(compra);

        // +1
        CompraResponse compraResponse = new CompraResponse(compra);

        return ResponseEntity.created(new URI("/compra/".concat(compraResponse.getId().toString()))).body(compraResponse);
    }
}
