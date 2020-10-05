package br.com.thyagoribeiro.casadocodigo.rest;

import br.com.thyagoribeiro.casadocodigo.domain.Pais;
import br.com.thyagoribeiro.casadocodigo.rest.contract.NovoPaisRequest;
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
public class NovoPaisController {

    @PersistenceContext
    EntityManager entityManager;

    @PostMapping(value = "/api/pais")
    @Transactional
    public ResponseEntity<?> novoPais(@RequestBody @Valid NovoPaisRequest novoPaisRequest) { // CDD 1 - Classe NovoPaisRequest
        Pais pais = novoPaisRequest.toModel(); // CDD 1 - Classe Pais
        entityManager.persist(pais);
        return ResponseEntity.ok().body(novoPaisRequest);
    }

}
