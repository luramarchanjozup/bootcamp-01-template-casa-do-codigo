package br.com.treino.casadocodigo.controller;

import br.com.treino.casadocodigo.model.Compra;
import br.com.treino.casadocodigo.model.Livro;
import br.com.treino.casadocodigo.response.DetalheLivroResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RestController
@RequestMapping(value = "/livros")
public class LivroListaController {

    @PersistenceContext
    EntityManager entityManager;

    @GetMapping
    public ResponseEntity<?> listarTodosLivros(){ //1

        List<?> livros = entityManager
                .createQuery("select l from Livro l")
                .getResultList();

        return new ResponseEntity<>(livros, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DetalheLivroResponse> buscarLivroPorId(@PathVariable("id") long id){ //2

        Livro livro = entityManager.find(Livro.class, id);

        if (livro != null){ //3
            return new ResponseEntity<>(new DetalheLivroResponse(livro),
                    HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();

    }

}
