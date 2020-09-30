package br.com.thyagoribeiro.casadocodigo.rest;

import br.com.thyagoribeiro.casadocodigo.domain.Categoria;
import br.com.thyagoribeiro.casadocodigo.rest.contract.NovaCategoriaRequest;
import br.com.thyagoribeiro.casadocodigo.validator.NomeUnicoCategoriaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class CategoriaController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private NomeUnicoCategoriaValidator nomeUnicoCategoriaValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(nomeUnicoCategoriaValidator);
    }

    public CategoriaController(EntityManager entityManager, NomeUnicoCategoriaValidator nomeUnicoCategoriaValidator) {
        this.entityManager = entityManager;
        this.nomeUnicoCategoriaValidator = nomeUnicoCategoriaValidator;
    }

    @PostMapping(value = "/api/categoria")
    @Transactional
    public ResponseEntity<?> novaCategoria(@RequestBody @Valid NovaCategoriaRequest novaCategoriaRequest) {
        Categoria categoria = novaCategoriaRequest.toModel();
        entityManager.persist(categoria);
        return ResponseEntity.ok().body(novaCategoriaRequest);
    }
}
