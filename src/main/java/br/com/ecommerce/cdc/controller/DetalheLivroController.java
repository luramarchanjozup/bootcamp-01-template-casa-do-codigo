package br.com.ecommerce.cdc.controller;

import br.com.ecommerce.cdc.domain.model.Livro;
import br.com.ecommerce.cdc.domain.response.DetalheLivroResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Carga intrínseca máxima permitida - 7
 * Carga intrínseca da classe - 3
 */


@RestController
@RequestMapping("/v2/livro/detalhe")
public class DetalheLivroController {

    @PersistenceContext
    private EntityManager manager;

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<?> detalheLivro(@PathVariable Long id){
        // +1
        Livro detalheLivro = manager.find(Livro.class, id);

        // +1
        if (!Optional.ofNullable(detalheLivro).isPresent()){
            return ResponseEntity.notFound().build();
        }
        // +1
        DetalheLivroResponse detalheLivroResponse = new DetalheLivroResponse(detalheLivro);

        return ResponseEntity.ok().body(detalheLivroResponse);
    }
}
