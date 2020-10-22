package br.com.casadocodigo.controller;

import br.com.casadocodigo.model.Livro;
import br.com.casadocodigo.model.NovoLivroRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class LivroController {

    @PersistenceContext
    private EntityManager entityManager;


    @PostMapping("/api/livro")
    @Transactional
    public String criaLivro(@Valid @RequestBody NovoLivroRequest novoLivroRequest){
        Livro novoLivro = novoLivroRequest.toLivro(entityManager);
        entityManager.persist(novoLivro);
        return novoLivro.toString();
    }

}
