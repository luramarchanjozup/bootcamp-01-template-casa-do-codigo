package com.example.apicasadocodigo.livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsultaLivroController {
    @Autowired
    private LivroRepository livroRepository;

    @GetMapping("/livros")
    public ResponseEntity<List<Livro>> listaLivros() {
        return ResponseEntity.ok().body(livroRepository.findAll());
    }

    @GetMapping("/livros/{id}")
    public ResponseEntity<Livro> buscaLivroPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(livroRepository.findById(id).get());
    }
}