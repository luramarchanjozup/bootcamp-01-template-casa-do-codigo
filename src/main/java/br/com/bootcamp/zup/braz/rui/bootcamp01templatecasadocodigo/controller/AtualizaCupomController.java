package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.controller;

import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.Cupom;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.requests.AtualizaCupomRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;

@RestController
@RequestMapping(value = "/atualizaCupom")
public class AtualizaCupomController {

    @Autowired
    EntityManager entityManager;

    @PutMapping
    @Transactional          //1                                         //1
    public ResponseEntity<Cupom> atualizaCupom(@RequestBody @Validated AtualizaCupomRequest atualizaCupomRequest){
        Cupom cupom = entityManager.find(Cupom.class, atualizaCupomRequest.getId());
        entityManager.merge(cupom);

        cupom.setCodigo(atualizaCupomRequest.getCodigo());
        cupom.setDesconto(atualizaCupomRequest.getDesconto());
        cupom.setValidade(atualizaCupomRequest.getValidade());

        return ResponseEntity.status(HttpStatus.OK).body(cupom);
    }
}
