package com.cdcAPI.api.controller;

import com.cdcAPI.api.model.LivroRequest;
import com.cdcAPI.model.Livro;
import com.cdcAPI.repository.LivroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

//Complexidade
//LivroRequest, Livro, LivroRepository
//Total = 3

@RestController
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private EntityManager manager;

    //Criar livro
    @PostMapping("/livros")
    @Transactional
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> criarLivro(@Valid @RequestBody LivroRequest livroRequest) throws Exception {
        Livro livro = livroRequest.toModel(manager);
        livroRepository.save(livro);

        return ResponseEntity.ok().build();
    }

    //Listar livros

}
