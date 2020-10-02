package com.example.apicasadocodigo.novolivro;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {
    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public String criarLivro(@Valid @RequestBody NovoLivroRequest request) {
        Livro novoLivro = request.toModel(manager);
        manager.persist(novoLivro);
        return "Livro " + novoLivro.getTitulo() + " criado.";
    }
}