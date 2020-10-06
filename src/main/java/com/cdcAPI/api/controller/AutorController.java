package com.cdcAPI.api.controller;

import com.cdcAPI.api.model.AutorRequest;
import com.cdcAPI.model.Autor;
import com.cdcAPI.repository.AutorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

//Complexidade
//AutorRequest, Autor, AutorRepository
//Total = 3

@RestController
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    //Criar autor
    @PostMapping("/autores")
    @Transactional // Garantir processo completo, tudo ou nada. (com o .persiste)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> criarAutor(@Valid @RequestBody AutorRequest autorRequest) {
        Autor autor = autorRequest.toModel(); //Request da entidade para Model
        autorRepository.save(autor);

        return ResponseEntity.ok().build();
    }
}
