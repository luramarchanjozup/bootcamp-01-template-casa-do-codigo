package br.com.treino.casadocodigo.controller;

import br.com.treino.casadocodigo.model.Autor;
import br.com.treino.casadocodigo.model.DetalheLivroRequest;
import br.com.treino.casadocodigo.model.Livro;
import br.com.treino.casadocodigo.model.NovoLivroRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
public class LivrosController {

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping(value = "/livros")
    public ResponseEntity<List<Livro>> getAllLivros(){
        List<Livro> livros = entityManager
                .createQuery("select l from Livro l").getResultList();

        System.out.println(livros);

        return new ResponseEntity<>(livros, HttpStatus.OK);
    }

    @GetMapping(value = "/livros/{id}")
    public ResponseEntity<DetalheLivroRequest> getLivroById(@PathVariable("id") long id){

        Livro livro = entityManager.find(Livro.class, id);

        if (livro == null){
            return ResponseEntity.notFound().build();
        }

        DetalheLivroRequest detalheLivroRequest = new DetalheLivroRequest(livro);

        return new ResponseEntity<>(detalheLivroRequest, HttpStatus.OK);
    }

    @PostMapping(value = "/livros")
    @Transactional
    public String novoLivro(@RequestBody @Valid NovoLivroRequest request){
        Livro novoLivro = request.toModel(entityManager);
        entityManager.persist(novoLivro);
        return novoLivro.toString();
    }

}
