package br.com.itau.casadocodigo.novolivro.controller;

import br.com.itau.casadocodigo.novolivro.model.Livro;
import br.com.itau.casadocodigo.novolivro.model.LivroRequest;
import br.com.itau.casadocodigo.novolivro.model.LivroResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class NovoLivroController {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Contagem de carga intrínseca no Controller: 3
     * @param livroRequest recebe na entrada: titulo, resumo, sumario, preco, numeroPaginas, isbn, dataLancamento, idAutor, idCategoria
     * @return um Json de Livro
     */
    @PostMapping(value = "/v1/livro")
    @Transactional
    public ResponseEntity<LivroResponse> publicaLivro(@RequestBody @Valid LivroRequest livroRequest) {
        Livro livro = livroRequest.toModel(entityManager);
        entityManager.persist(livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(new LivroResponse(livro));
    }
}
