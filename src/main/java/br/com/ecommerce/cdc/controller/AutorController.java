package br.com.ecommerce.cdc.controller;

import br.com.ecommerce.cdc.domain.model.Autor;
import br.com.ecommerce.cdc.domain.request.AutorRequest;
import br.com.ecommerce.cdc.domain.response.AutorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Carga intrinseca máxima permitida - 7
 * Carga intrinseca da classe - 3
 */

@RestController
@RequestMapping("/v2/autor")
public class AutorController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    // +2 (Autor, AutorRequest)
    public ResponseEntity<?> createAuthor(@RequestBody @Validated AutorRequest autorRequest){

        Autor autor = autorRequest.toModel();
        entityManager.persist(autor);
        // +1
        AutorResponse autorResponse = new AutorResponse(autor);

        return ResponseEntity.ok(autorResponse);
    }

}
