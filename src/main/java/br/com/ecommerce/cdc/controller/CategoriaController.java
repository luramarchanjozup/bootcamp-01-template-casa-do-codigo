package br.com.ecommerce.cdc.controller;

import br.com.ecommerce.cdc.domain.model.Categoria;
import br.com.ecommerce.cdc.domain.request.CategoriaRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Carga intrinseca máxima permitida - 7
 * Carga intrinseca da classe - 2
 */

@RestController
@RequestMapping("/v2/categoria")
public class CategoriaController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    // +2
    public ResponseEntity<?> criaCategoria(@RequestBody @Validated CategoriaRequest categoriaRequest){
        Categoria categoria = categoriaRequest.toCategoria();
        entityManager.persist(categoria);
        return ResponseEntity.ok().build();
    }
}
