package br.com.treino.casadocodigo.controller;

import br.com.treino.casadocodigo.model.Livro;
import br.com.treino.casadocodigo.model.NovoLivroRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class LivrosController {

    @PersistenceContext
    EntityManager entityManager;

    @PostMapping(value = "/livros")
    @Transactional
    public String novoLivro(@RequestBody @Valid NovoLivroRequest request){

        Livro novoLivro = request.toModel(entityManager);
        entityManager.persist(novoLivro);
        return novoLivro.toString();
    }

}
