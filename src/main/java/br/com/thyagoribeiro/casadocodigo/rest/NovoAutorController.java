package br.com.thyagoribeiro.casadocodigo.rest;

import br.com.thyagoribeiro.casadocodigo.domain.Autor;
import br.com.thyagoribeiro.casadocodigo.rest.contract.NovoAutorRequest;
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
public class NovoAutorController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping(value = "/api/autor")
    @Transactional
    public ResponseEntity<?> novoAutor(@RequestBody @Valid NovoAutorRequest novoAutorRequest) { // CDD 1 - Classe NovoAutorRequest
        Autor autor = novoAutorRequest.toModel(); // CDD 1 - Classe Autor
        entityManager.persist(autor);
        return ResponseEntity.ok().body(novoAutorRequest);
    }

}
