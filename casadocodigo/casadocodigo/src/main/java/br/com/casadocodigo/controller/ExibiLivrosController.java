package br.com.casadocodigo.controller;

import br.com.casadocodigo.model.Livro;
import br.com.casadocodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExibiLivrosController {

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping("api/livros")
    public ResponseEntity<List<Livro>> listaLivros(){
        return ResponseEntity.ok().body(livroRepository.findAll());
    }

    @GetMapping("api/livros/{id}")
    public ResponseEntity<Livro> listaLivroId(@PathVariable Long id){
        return ResponseEntity.ok().body(livroRepository.findById(id).get());
    }
}

