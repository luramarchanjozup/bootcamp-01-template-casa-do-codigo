package br.com.treino.casadocodigo.controller;

import br.com.treino.casadocodigo.model.Livro;
import br.com.treino.casadocodigo.model.NovoLivroRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
        return new ResponseEntity<>(livros, HttpStatus.OK);
    }

    @PostMapping(value = "/livros")
    @Transactional
    public String novoLivro(@RequestBody @Valid NovoLivroRequest request){
        Livro novoLivro = request.toModel(entityManager);
        entityManager.persist(novoLivro);
        return novoLivro.toString();
    }

}
