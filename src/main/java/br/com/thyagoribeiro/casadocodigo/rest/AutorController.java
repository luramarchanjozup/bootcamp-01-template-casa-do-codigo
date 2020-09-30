package br.com.thyagoribeiro.casadocodigo.rest;

import br.com.thyagoribeiro.casadocodigo.domain.Autor;
import br.com.thyagoribeiro.casadocodigo.rest.contract.NovoAutorRequest;
import br.com.thyagoribeiro.casadocodigo.validator.EmailUnicoAutorValidator;
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
public class AutorController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private EmailUnicoAutorValidator emailUnicoAutorValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(emailUnicoAutorValidator);
    }

    public AutorController(EntityManager entityManager, EmailUnicoAutorValidator emailUnicoAutorValidator) {
        this.entityManager = entityManager;
        this.emailUnicoAutorValidator = emailUnicoAutorValidator;
    }

    @PostMapping(value = "/api/autor")
    @Transactional
    public ResponseEntity<?> novoAutor(@RequestBody @Valid NovoAutorRequest novoAutorRequest) {
        Autor autor = novoAutorRequest.toModel();
        entityManager.persist(autor);
        return ResponseEntity.ok(novoAutorRequest);
    }

}
