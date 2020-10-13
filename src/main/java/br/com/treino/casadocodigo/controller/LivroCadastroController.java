package br.com.treino.casadocodigo.controller;

import br.com.treino.casadocodigo.model.Livro;
import br.com.treino.casadocodigo.request.NovoLivroRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/livros")
public class LivroCadastroController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity novoLivro(@RequestBody @Valid NovoLivroRequest request){ //1

        Livro novoLivro = request.toModel(entityManager); //2
        entityManager.persist(novoLivro);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
