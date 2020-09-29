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

@RestController
public class AutorController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping(value = "/api/autor")
    @Transactional
    public ResponseEntity<?> novoAutor(@RequestBody @Valid NovoAutorRequest novoAutorRequest) {
        Autor autor = novoAutorRequest.toModel();
        entityManager.persist(autor);
        return ResponseEntity.ok(novoAutorRequest);
    }

}
