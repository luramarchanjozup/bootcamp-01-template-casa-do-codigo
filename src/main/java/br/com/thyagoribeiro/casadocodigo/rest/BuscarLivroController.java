package br.com.thyagoribeiro.casadocodigo.rest;

import br.com.thyagoribeiro.casadocodigo.domain.Livro;
import br.com.thyagoribeiro.casadocodigo.utils.ErroPadronizado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;

// CDD - Total: 3

@RestController
public class BuscarLivroController {

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping(value = "/api/livro/{livroId}")
    public ResponseEntity<?> buscarLivro(@PathVariable Long livroId) {

        Livro livro = entityManager.find(Livro.class, livroId); // CDD 1 - Classe Livro
        if(livro == null) // CDD 1 - branch if
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErroPadronizado(Arrays.asList("ID de livro não encontrado"))); // CDD 1 - Classe ErroPadronizado

        return ResponseEntity.ok().body(livro);
    }
}
