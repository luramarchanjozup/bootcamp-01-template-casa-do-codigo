package br.com.treino.casadocodigo.controller;

import br.com.treino.casadocodigo.model.Cupom;
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

    @PostMapping
    @Transactional
    public Cupom novoCupom(@RequestBody @Valid Cupom cupom){
        return cupom;
    }

}
