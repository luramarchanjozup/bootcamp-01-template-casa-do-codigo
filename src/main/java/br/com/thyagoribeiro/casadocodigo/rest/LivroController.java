package br.com.thyagoribeiro.casadocodigo.rest;

import br.com.thyagoribeiro.casadocodigo.domain.Livro;
import br.com.thyagoribeiro.casadocodigo.rest.contract.NovoLivroRequest;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class LivroController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping(value = "/api/livro")
    @Transactional
    public ResponseEntity<?> novoLivro(@RequestBody @Valid NovoLivroRequest novoLivroRequest) {
        Livro livro = novoLivroRequest.toModel();
        entityManager.persist(livro);
        return ResponseEntity.ok().body(novoLivroRequest);
    }

}
