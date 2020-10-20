package br.com.thyagoribeiro.casadocodigo.rest;

import br.com.thyagoribeiro.casadocodigo.domain.Estado;
import br.com.thyagoribeiro.casadocodigo.rest.contract.NovoEstadoRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

// CDD - Total: 2

@RestController
public class NovoEstadoController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping(value = "/api/estado")
    @Transactional
    public ResponseEntity<?> novoEstado(@RequestBody @Valid NovoEstadoRequest novoEstadoRequest) { // CDD 1 - classe NovoEstadoRequest
        Estado estado = novoEstadoRequest.toModel(); // CDD 1 - classe Estado
        entityManager.persist(estado);
        return ResponseEntity.ok().body(novoEstadoRequest);
    }

}
