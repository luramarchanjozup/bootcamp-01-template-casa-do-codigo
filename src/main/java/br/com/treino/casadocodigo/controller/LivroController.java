package br.com.treino.casadocodigo.controller;

import br.com.treino.casadocodigo.repository.LivroRepository;
import br.com.treino.casadocodigo.request.DetalheLivroRequest;
import br.com.treino.casadocodigo.model.Livro;
import br.com.treino.casadocodigo.request.NovoLivroRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
public class LivroController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private LivroRepository livroRepository;  //1

    @GetMapping(value = "/livros")
    public ResponseEntity<Iterable<Livro>> getAllLivros(){ //2

        //List<Livro> livros = entityManager
        //        .createQuery("select l from Livro l").getResultList();

        Iterable<Livro> livros = livroRepository.findAll();

        return new ResponseEntity<>(livros, HttpStatus.OK);
    }

    @GetMapping(value = "/livros/{id}")
    public ResponseEntity<DetalheLivroRequest> getLivroById(@PathVariable("id") long id){ //3

        Optional<Livro> optionalLivro = livroRepository.findById(id);

        if (optionalLivro.isPresent()){
            DetalheLivroRequest detalheLivroRequest =
                    new DetalheLivroRequest(optionalLivro.get());
            return new ResponseEntity<>(detalheLivroRequest, HttpStatus.OK);
        }
            return ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/livros")
    @Transactional
    public ResponseEntity novoLivro(@RequestBody @Valid NovoLivroRequest request){ //4

        Livro novoLivro = request.toModel(entityManager);
        //entityManager.persist(novoLivro);

        livroRepository.save(novoLivro);

        return new ResponseEntity(HttpStatus.OK);
    }

}
