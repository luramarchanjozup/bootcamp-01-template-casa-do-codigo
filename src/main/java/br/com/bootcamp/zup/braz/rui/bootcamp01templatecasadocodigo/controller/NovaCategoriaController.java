package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.controller;

import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.Categoria;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.requests.NovaCategoriaRequest;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.validation.CategoriaUnicaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/novaCategoria")
public class NovaCategoriaController {

    @Autowired
    EntityManager entityManager;

    //Cadastrar uma nova Categoria
    @PostMapping
    @Transactional
    public ResponseEntity<Categoria> novaCategoria(@Validated @RequestBody NovaCategoriaRequest novaCategoriaRequest){

        Categoria novaCategoria = novaCategoriaRequest.toModel();
        entityManager.persist(novaCategoria);
        return ResponseEntity.status(HttpStatus.OK).body(novaCategoria);
    }
}