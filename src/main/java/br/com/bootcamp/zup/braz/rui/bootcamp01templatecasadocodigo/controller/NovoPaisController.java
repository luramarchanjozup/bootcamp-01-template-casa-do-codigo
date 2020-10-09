package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.controller;

import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.Pais;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.requests.NovoPaisRequest;
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
import javax.swing.text.html.parser.Entity;

@RestController
@RequestMapping(value = "/novoPais")
public class NovoPaisController {

    @Autowired
    EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<Pais> novoPais(@Validated @RequestBody NovoPaisRequest novoPaisRequest){

        Pais novoPais = novoPaisRequest.toModel();

        entityManager.persist(novoPais);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPais);
    }
}
