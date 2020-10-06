package br.com.zup.treinocasadocodigo.controllers;

import br.com.zup.treinocasadocodigo.entities.Livro;
import br.com.zup.treinocasadocodigo.entities.LivroNovoRequest;
import br.com.zup.treinocasadocodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

/**
 * Contagem de carga intrínseca da classe: 2
 */

@RestController
public class LivroController {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private LivroRepository livroRepository;

    @PostMapping("/livros")
    @Transactional
    //1
    public String cadastroLivro(@RequestBody @Valid LivroNovoRequest livroNovo) {
        //1
        Livro livro = livroNovo.toModel(manager);
        manager.persist(livro);
        return livro.toString();
    }

    @GetMapping("/livros")
    public List<Livro> todosLivros() {
        return livroRepository.findAll();
    }
}
