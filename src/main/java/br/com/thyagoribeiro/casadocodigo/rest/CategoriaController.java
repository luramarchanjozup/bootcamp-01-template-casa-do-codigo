package br.com.thyagoribeiro.casadocodigo.rest;

import br.com.thyagoribeiro.casadocodigo.domain.Categoria;
import br.com.thyagoribeiro.casadocodigo.rest.contract.NovaCategoriaRequest;
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
public class CategoriaController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping(value = "/api/categoria")
    @Transactional
    public ResponseEntity<?> novaCategoria(@RequestBody @Valid NovaCategoriaRequest novaCategoriaRequest) { // CDD 1 - Classe NovaCategoriaRequest
        Categoria categoria = novaCategoriaRequest.toModel(); // CDD 1 - Classe Categoria
        entityManager.persist(categoria);
        return ResponseEntity.ok().body(novaCategoriaRequest);
    }
}
