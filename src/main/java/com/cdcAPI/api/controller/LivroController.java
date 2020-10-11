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

//Complexidade = ?
//LivroRequest, Livro, LivroRepository, if, toModel?, find's?

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
    public ResponseEntity<Void> criarLivro(@Valid @RequestBody LivroRequest livroRequest) throws Exception {
        Livro livro = livroRequest.toModel(manager);
        manager.persist(livro);

        return ResponseEntity.ok().build();
    }

    //Listar livros
    @GetMapping
    public ResponseEntity<List<Livro>> listarLivros() {

        //createQuery("select b from book b", Book.class).getResultList();
        //Livros livros = manager.createQuery

        return ResponseEntity.ok(livroRepository.findAll());//ToDo Usar manager
    }

    //Detalhes do livro peli ID
    @GetMapping("/{livroId}")
    public ResponseEntity<LivroResponse> detalhesLivro(@PathVariable Long livroId) {

        //Livro livro = manager.find(Livro.class, livroId); // ToDo Usar manager, verificar null?

        Optional<Livro> livro = livroRepository.findById(livroId);
        if (livro.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        LivroResponse livroResponse = new LivroResponse(livro.get());
        return ResponseEntity.ok(livroResponse);
    }

}
