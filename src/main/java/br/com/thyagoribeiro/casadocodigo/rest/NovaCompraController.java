package br.com.thyagoribeiro.casadocodigo.rest;

import br.com.thyagoribeiro.casadocodigo.domain.Compra;
import br.com.thyagoribeiro.casadocodigo.rest.contract.NovaCompraRequest;
import br.com.thyagoribeiro.casadocodigo.validator.EstadoPertencePaisValidator;
import br.com.thyagoribeiro.casadocodigo.validator.ValorTotalValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

// CDD - Total: 4

@RestController
public class NovaCompraController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private EstadoPertencePaisValidator estadoPertencePaisValidator; // CDD 1 - Classe EstadoPertencePaisValidator

    @Autowired
    private ValorTotalValidator valorTotalValidator; // CDD 1 - Classe ValorTotalValidator

    @InitBinder
    public void init(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(
            estadoPertencePaisValidator,
                valorTotalValidator
        );
    }

    @PostMapping(value = "/api/compra")
    @Transactional
    public ResponseEntity<?> novaCompra(@RequestBody @Valid NovaCompraRequest novaCompraRequest, UriComponentsBuilder builder) { // CDD 1 - Classe NovaCompraRequest
        Compra compra = novaCompraRequest.toModel(); // CDD 1 - Classe Compra
        entityManager.persist(compra);
        URI enderecoConsulta = builder.path("/api/compra/{id}").build(compra.getId());
        return ResponseEntity.created(enderecoConsulta).build();
    }

}
