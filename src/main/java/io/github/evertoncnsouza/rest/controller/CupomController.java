package io.github.evertoncnsouza.rest.controller;

import io.github.evertoncnsouza.rest.dto.CupomRequest;
import io.github.evertoncnsouza.domain.entity.Cupom;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

//2 PCI's
@RestController
@RequestMapping("api/cupons")
public class CupomController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public String save(@RequestBody @Valid CupomRequest request) { //PCI 1;
        Cupom cupom = request.toModel(); //PCI 2;
        manager.persist(cupom);
        return cupom.toString();
    }
}
