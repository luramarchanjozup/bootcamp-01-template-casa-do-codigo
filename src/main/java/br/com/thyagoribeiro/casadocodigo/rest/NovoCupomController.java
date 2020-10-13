package br.com.thyagoribeiro.casadocodigo.rest;

import br.com.thyagoribeiro.casadocodigo.domain.Cupom;
import br.com.thyagoribeiro.casadocodigo.rest.contract.NovaCompraRequest;
import br.com.thyagoribeiro.casadocodigo.rest.contract.NovoCupomRequest;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

// CDD - Total 2

@RestController
public class NovoCupomController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping(value = "/api/cupom")
    @Transactional
    public ResponseEntity<?> novoCupom(@RequestBody @Valid NovoCupomRequest novoCupomRequest, UriComponentsBuilder builder) { // CDD 1 - Classe NovoCupomRequest
        Cupom cupom = novoCupomRequest.toModel(); // CDD 1 - Classe Cupom
        entityManager.persist(cupom);
        URI enderecoConsulta = builder.path("/api/cupom/{id}").build(cupom.getId());
        return ResponseEntity.created(enderecoConsulta).build();
    }
}
