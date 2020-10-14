package br.com.ecommerce.cdc.controller;

import br.com.ecommerce.cdc.domain.model.Categoria;
import br.com.ecommerce.cdc.domain.request.CategoriaRequest;
import br.com.ecommerce.cdc.domain.response.CategoriaResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Carga intrinseca máxima permitida - 7
 * Carga intrinseca da classe - 3
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
        // +1
        CategoriaResponse categoriaResponse= new CategoriaResponse(categoria);

        return ResponseEntity.ok(categoriaResponse);
    }
}
