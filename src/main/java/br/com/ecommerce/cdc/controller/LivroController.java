package br.com.ecommerce.cdc.controller;

import br.com.ecommerce.cdc.domain.model.Autor;
import br.com.ecommerce.cdc.domain.model.Categoria;
import br.com.ecommerce.cdc.domain.model.Livro;
import br.com.ecommerce.cdc.domain.request.LivroRequest;
import br.com.ecommerce.cdc.domain.response.LivroResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Carga intrínseca máxima permitida - 7
 * Carga intrínseca da classe - 7
 *
 */

@RestController
@RequestMapping("/v2/livro")
public class LivroController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    // +1 (LivroRequest)
    public ResponseEntity<?> criaLivro(@RequestBody @Validated LivroRequest livroRequest){
        // +1
        Autor autor = manager.find(Autor.class, livroRequest.getAutor());
        // +1
        Categoria categoria = manager.find(Categoria.class, livroRequest.getCategoria());
        // +1
        Livro livro = livroRequest.toModel(autor, categoria);
        manager.persist(livro);
        //+1
        LivroResponse livroResponse = new LivroResponse(livro);

        return ResponseEntity.ok().body(livroResponse);
    }

    @GetMapping
    @Transactional
    public ResponseEntity<?> listaLivros(){
        List<Livro> todosLivros  = manager.createQuery("select c from Livro c ").getResultList();
        List<LivroResponse> livrosResponse = todosLivros.stream()
                // +2
                .map(livro -> {
                    return new LivroResponse(livro);
                }).collect(Collectors.toList());
        return ResponseEntity.ok().body(livrosResponse);
    }

}
