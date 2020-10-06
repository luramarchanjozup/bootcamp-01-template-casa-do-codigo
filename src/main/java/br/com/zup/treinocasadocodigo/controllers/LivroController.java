package br.com.zup.treinocasadocodigo.controllers;

import br.com.zup.treinocasadocodigo.entities.Livro;
import br.com.zup.treinocasadocodigo.entities.LivroNovoRequest;
import br.com.zup.treinocasadocodigo.entities.LivroRetornoLista;
import br.com.zup.treinocasadocodigo.entities.LivroRetornoDetalhes;
import br.com.zup.treinocasadocodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Contagem de carga intrínseca da classe: 7
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
    public List<LivroRetornoLista> todosLivros() {
        //1
        return livroRepository
                .findAll()
                .stream()
                .map(LivroRetornoLista::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    //1
    public ResponseEntity<LivroRetornoDetalhes> detalhesLivro(@PathVariable("id") Long id) {
        Livro livro = manager.find(Livro.class, id);
        //1
        if (livro == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(new LivroRetornoDetalhes(livro));
    }
}
