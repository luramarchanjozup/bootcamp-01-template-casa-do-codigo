package br.com.thyagoribeiro.casadocodigo.rest;

import br.com.thyagoribeiro.casadocodigo.domain.Autor;
import br.com.thyagoribeiro.casadocodigo.domain.Livro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

// CDD - Total: 1

@RestController
public class ListaLivrosController {

    @PersistenceContext
    private EntityManager entityManager;


    @GetMapping(value = "/api/livro")
    public ResponseEntity<?> listaLivros() {
        Query query = entityManager.createQuery("SELECT l FROM Livro l", Livro.class); // CDD 1 - Classe Livro
        List<Livro> livros = query.getResultList();

        return ResponseEntity.ok().body(livros);
    }

}
