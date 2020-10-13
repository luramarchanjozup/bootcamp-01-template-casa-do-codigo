package com.cdcAPI.api.controller;

import com.cdcAPI.api.model.Request.LivroRequest;
import com.cdcAPI.api.model.Response.LivroResponse;
import com.cdcAPI.model.Livro;
import com.cdcAPI.repository.LivroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

//Complexidade = 7
//LivroRequest, Livro, LivroRepository, if, elseif, Livro response, if

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private EntityManager manager;

    //Criar livro
    @PostMapping
    @Transactional
    //1 LivroRequest
    public ResponseEntity<Void> criarLivro(@Valid @RequestBody LivroRequest livroRequest) throws Exception {

        //2 Livro
        Livro livro = livroRequest.toModel(manager);

        //3 if
        if (livro.getAutor() == null) {
            throw new Exception("Livro não pode ser cadastrado. Autor não existe.");
        }
        //4 elseif
        else if (livro.getCategoria() == null) {
            throw new Exception("Livro não pode ser cadastrado. Categoria não existe.");
        }

        manager.persist(livro);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Livro>> listarLivros() {

        //5 livroRepository
        return ResponseEntity.ok(livroRepository.findAll());
    }

    @GetMapping("/{livroId}")
    //6 LivroResponse
    public ResponseEntity<LivroResponse> detalhesLivro(@PathVariable Long livroId) {

        Livro livro = manager.find(Livro.class, livroId);
        //7 if
        if (livro == null){
            return ResponseEntity.notFound().build();
        }
        LivroResponse livroResponse = new LivroResponse(livro);

        return ResponseEntity.ok(livroResponse);
    }
}
