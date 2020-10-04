package br.com.ecommerce.cdc.controller;

import br.com.ecommerce.cdc.domain.Autor;
import br.com.ecommerce.cdc.domain.AutorRequest;
import br.com.ecommerce.cdc.validation.UniqueEmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Carga intrinseca máxima permitida - 7
 * Carga intrinseca da classe - 2
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

        return ResponseEntity.ok().build();
    }

}
