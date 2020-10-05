package br.com.treino.casadocodigo.controller;

import br.com.treino.casadocodigo.request.DetalheLivroRequest;
import br.com.treino.casadocodigo.model.Livro;
import br.com.treino.casadocodigo.request.NovoLivroRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
public class LivroController {

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping(value = "/livros")
    public ResponseEntity<List<Livro>> getAllLivros(){ //1
        List<Livro> livros = entityManager
                .createQuery("select l from Livro l").getResultList();
        return new ResponseEntity<>(livros, HttpStatus.OK);
    }

    @GetMapping(value = "/livros/{id}")
    public ResponseEntity<DetalheLivroRequest> getLivroById(@PathVariable("id") long id){ //2

        Livro livro = entityManager.find(Livro.class, id);
        if (livro == null){
            return ResponseEntity.notFound().build();
        }
        DetalheLivroRequest detalheLivroRequest = new DetalheLivroRequest(livro);
        return new ResponseEntity<>(detalheLivroRequest, HttpStatus.OK);
    }

    @PostMapping(value = "/livros")
    @Transactional
    public ResponseEntity novoLivro(@RequestBody @Valid NovoLivroRequest request){ //3
        Livro novoLivro = request.toModel(entityManager);
        entityManager.persist(novoLivro);
        return new ResponseEntity(HttpStatus.OK);
    }

}
