package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.controller;

import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.Autor;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.requests.NovoAutorRequest;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.validation.EmailDuplicadoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;


@RestController
@RequestMapping(value = "/cadastrarAutor")
public class NovoAutorController {

    @Autowired
    EntityManager entityManager;

    @Autowired
    EmailDuplicadoValidator emailDuplicadoValidator;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(emailDuplicadoValidator);
    }

    //Cadastrar um novo Autor
    @PostMapping
    @Transactional
    public ResponseEntity<Autor> cadastrarAutor(@Validated @RequestBody NovoAutorRequest novoAutorRequest){

        Autor novoAutor = novoAutorRequest.toModel();
        entityManager.persist(novoAutor);
        return ResponseEntity.status(HttpStatus.OK).body(novoAutor);
    }
}
