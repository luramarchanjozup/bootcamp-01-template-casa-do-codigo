package com.cdcAPI.api.controller;

import com.cdcAPI.api.model.CategoriaRequest;
import com.cdcAPI.model.Categoria;
import com.cdcAPI.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RestController
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    //Criar categoria
    @PostMapping("/categorias")
    @Transactional
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> criarCategoria(@Valid @RequestBody CategoriaRequest categoriaRequest) {
        Categoria categoria = categoriaRequest.toModel();
        categoriaRepository.save(categoria);

        return ResponseEntity.ok().build();
    }
}
