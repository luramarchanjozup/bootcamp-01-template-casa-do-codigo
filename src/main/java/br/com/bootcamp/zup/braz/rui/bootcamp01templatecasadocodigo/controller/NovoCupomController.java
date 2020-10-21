package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.controller;

import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.Cupom;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.requests.NovoCupomRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;

@RestController
@RequestMapping(value = "/novoCupom")
public class NovoCupomController {

    @Autowired
    EntityManager entityManager;

    @PostMapping
    @Transactional          //1                                         //1
    public ResponseEntity<Cupom> novoCupom(@Validated @RequestBody NovoCupomRequest novoCupomRequest){
        Cupom cupom = novoCupomRequest.toModel();
        entityManager.persist(cupom);
        return ResponseEntity.status(HttpStatus.CREATED).body(cupom);

    }
}
