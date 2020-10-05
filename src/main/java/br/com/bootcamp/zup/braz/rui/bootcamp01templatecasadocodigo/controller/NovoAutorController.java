package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.controller;

import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.requests.NovoAutorRequest;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.services.NovoAutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@RestController
@RequestMapping(value = "/cadastrarAutor")
public class NovoAutorController {

    @Autowired
    NovoAutorService novoAutorService;

    //Cadastrar um novo Autor
    @PostMapping
    public ResponseEntity<Void> cadastrarAutor(@Validated @RequestBody NovoAutorRequest novoAutorRequest){

        novoAutorService.cadastrar(novoAutorRequest.getNome(), novoAutorRequest.getEmail(), novoAutorRequest.getDescricao(), LocalDateTime.now());
        return ResponseEntity.ok().build();
    }
}
