package com.github.marcoscoutozup.casadocodigo.fluxocompra.cupom;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/cupom")
public class CupomController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public String cadastrarCupom(@RequestBody @Valid CupomDTO dto){
        Cupom cupom = dto.toModel();
        entityManager.persist(cupom);
        return cupom.toString();
    }

}
