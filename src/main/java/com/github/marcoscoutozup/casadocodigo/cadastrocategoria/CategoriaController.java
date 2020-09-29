package com.github.marcoscoutozup.casadocodigo.cadastrocategoria;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public Categoria cadastrarCategoria(@RequestBody @Valid CategoriaDTO dto){
        Categoria categoria = dto.toModel();
        entityManager.persist(categoria);
        return categoria;
    }

}
