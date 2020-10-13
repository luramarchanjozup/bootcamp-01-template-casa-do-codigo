package br.com.treino.casadocodigo.controller;

import br.com.treino.casadocodigo.request.NovoPaisRequest;
import br.com.treino.casadocodigo.model.Pais;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class PaisController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping(value = "/pais")
    @Transactional
    public ResponseEntity novoPais(@RequestBody @Valid NovoPaisRequest request){ //1
        Pais pais = new Pais(request.getNome()); //2
        entityManager.persist(pais);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
