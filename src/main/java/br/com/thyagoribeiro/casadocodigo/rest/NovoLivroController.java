package br.com.thyagoribeiro.casadocodigo.rest;

import br.com.thyagoribeiro.casadocodigo.domain.Livro;
import br.com.thyagoribeiro.casadocodigo.rest.contract.NovoLivroRequest;
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
public class NovoLivroController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping(value = "/api/livro")
    @Transactional
    public ResponseEntity<?> novoLivro(@RequestBody @Valid NovoLivroRequest novoLivroRequest) { // CDD 1 - Classe NovoLivroRequest
        Livro livro = novoLivroRequest.toModel(); // CDD 1 - Classe Livro
        entityManager.persist(livro);
        return ResponseEntity.ok().body(novoLivroRequest);
    }

}
