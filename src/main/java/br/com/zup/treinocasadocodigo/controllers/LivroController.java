package br.com.zup.treinocasadocodigo.controllers;

import br.com.zup.treinocasadocodigo.entities.Livro;
import br.com.zup.treinocasadocodigo.entities.LivroNovoRequest;
import br.com.zup.treinocasadocodigo.entities.LivroRetorno;
import br.com.zup.treinocasadocodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Contagem de carga intrínseca da classe: 5
 */

@RestController
@RequestMapping("/livros")
public class LivroController {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    //1
    private LivroRepository livroRepository;

    @PostMapping()
    @Transactional
    //1
    public String cadastroLivro(@RequestBody @Valid LivroNovoRequest livroNovo) {
        //1
        Livro livro = livroNovo.toModel(manager);
        manager.persist(livro);
        return livro.toString();
    }

    @GetMapping()
    //1
    public List<LivroRetorno> todosLivros() {
        //1
        return livroRepository
                .findAll()
                .stream()
                .map(LivroRetorno::new)
                .collect(Collectors.toList());
    }
}
