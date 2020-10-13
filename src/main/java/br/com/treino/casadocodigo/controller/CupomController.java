package br.com.treino.casadocodigo.controller;

import br.com.treino.casadocodigo.model.Cupom;
import br.com.treino.casadocodigo.request.AtualizaCupomRequest;
import br.com.treino.casadocodigo.request.NovoCupomRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.text.html.parser.Entity;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/cupons")
public class CupomController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity novoCupom(@RequestBody @Valid NovoCupomRequest request){ //1
        Cupom novoCupom = request.toModel(); //2
        entityManager.persist(novoCupom);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    @Transactional
    public ResponseEntity atualizaCoupm(@PathVariable("id") Long id,
                              @RequestBody @Valid AtualizaCupomRequest request){ //3

        Cupom cupomAtualizado = entityManager.find(Cupom.class, id);

        if (cupomAtualizado != null){
            cupomAtualizado.atualizarCupom(request);
            entityManager.merge(cupomAtualizado);
            return new ResponseEntity(HttpStatus.OK);
        }

        return ResponseEntity.notFound().build();

    }


}
