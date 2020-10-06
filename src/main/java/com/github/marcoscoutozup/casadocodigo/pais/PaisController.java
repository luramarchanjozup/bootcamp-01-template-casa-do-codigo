package com.github.marcoscoutozup.casadocodigo.pais;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/pais")
public class PaisController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional                                  //1
    public String cadastrarPais(@RequestBody @Valid PaisDTO dto){
        Pais pais = dto.toModel();
        entityManager.persist(pais);
        return pais.toString();
    }

}
