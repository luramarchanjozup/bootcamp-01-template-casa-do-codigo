package br.com.itau.casadocodigo.exibelivros.controller;

import br.com.itau.casadocodigo.exibelivros.model.ExibeLivroResponse;
import br.com.itau.casadocodigo.novolivro.model.Livro;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@RestController
public class ExibeLivrosController {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Contagem de carga intrínseca no Controller: 1
     * @return a lista de todos os livros cadastrados
     */
    @GetMapping(value = "/v1/lista")
    public List<Livro> exibeLista() {
        Query query = entityManager.createQuery("select b from Livro b");

        return query.getResultList();
    }

    /**
     * Contagem de carga intrínseca no Controller: 3
     * @param id do livro
     * @return o detalhe do livro específico
     */
    @GetMapping(value = "/v1/lista/{id}")
    public ResponseEntity<ExibeLivroResponse> exibeDetalheLivro(@PathVariable("id") Long id) {
        Livro exibeLivros = entityManager.find(Livro.class, id);

        if (exibeLivros == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(new ExibeLivroResponse(exibeLivros));
    }
}
