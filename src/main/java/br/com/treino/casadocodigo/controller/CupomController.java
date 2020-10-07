package br.com.treino.casadocodigo.controller;

import br.com.treino.casadocodigo.model.Cupom;
import br.com.treino.casadocodigo.request.NovoCupomRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.text.html.parser.Entity;
import javax.validation.Valid;

@RestController
public class CupomController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping(value = "/cupom")
    @Transactional
    public void novoCupom(@RequestBody @Valid NovoCupomRequest request){
        Cupom cupom = request.toModel();
        entityManager.persist(cupom);
        //return new ResponseEntity<>(cupom, HttpStatus.OK);
    }

}
