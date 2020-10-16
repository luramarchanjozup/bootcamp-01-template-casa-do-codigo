package com.bootcamp.cdd.controllers;

import com.bootcamp.cdd.models.Country;
import com.bootcamp.cdd.models.Shopping;
import com.bootcamp.cdd.models.State;
import com.bootcamp.cdd.request.ShoppingRequest;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/shopping")
public class ShoppingController {
    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public Shopping createShopping (@Valid @RequestBody ShoppingRequest request) {
        Assert.isTrue(verifyDocs(request.getDocumento()), "o documento foi preenchido de forma incorreta");
        Country pais = entityManager.find(Country.class, request.getPais());
        Shopping compra = request.toModel(entityManager);
        compra.setPais(pais);
        if (request.getEstadoId() != null) {
            State estado = entityManager.find(State.class, request.getEstadoId());
            Assert.isTrue(estado.getCountryId() == pais.getId(), "O estado não faz parte do pais informado");
            compra.setEstado(estado);
        }
        entityManager.persist(compra);
        return compra;
    }

    public boolean verifyDocs (String document) {
        boolean isCpf = document.length() == 11;
        boolean isCnpj = document.length() == 14;
        return isCpf || isCnpj;
    }

    public void addCumpom (Shopping compra) {

    }
}
