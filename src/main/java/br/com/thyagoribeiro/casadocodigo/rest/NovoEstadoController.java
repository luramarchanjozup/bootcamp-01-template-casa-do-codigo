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



@RestController
public class NovoEstadoController {

    @PersistenceContext
    EntityManager entityManager;

    @PostMapping(value = "/api/estado")
    @Transactional
    public ResponseEntity<?> novoEstado(@RequestBody @Valid NovoEstadoRequest novoEstadoRequest) {
        Estado estado = novoEstadoRequest.toModel();
        entityManager.persist(estado);
        return ResponseEntity.ok().body(novoEstadoRequest);
    }

}
