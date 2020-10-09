package br.com.treino.casadocodigo.controller;

import br.com.treino.casadocodigo.model.Cupom;
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
@RequestMapping("/cupom")
public class CupomController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity novoCupom(@RequestBody @Valid NovoCupomRequest request){
        Cupom cupom = request.toModel();
        entityManager.persist(cupom);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    @Transactional
    public ResponseEntity atualizaCoupm(@PathVariable(value = "id") Long id,
                              @RequestBody @Valid NovoCupomRequest request){

        Cupom cupomAtualizado = entityManager.find(Cupom.class, id);
        cupomAtualizado.setCodigo(request.getCodigo());
        cupomAtualizado.setPercentualDesconto(request.getPercentualDesconto());
        cupomAtualizado.setValidade(request.getValidade());
        entityManager.merge(cupomAtualizado);

        return new ResponseEntity(HttpStatus.OK);
    }

}
