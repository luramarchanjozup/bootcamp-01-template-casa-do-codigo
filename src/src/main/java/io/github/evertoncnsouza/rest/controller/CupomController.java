package io.github.evertoncnsouza.rest.controller;

import io.github.evertoncnsouza.domain.entity.Cupom;
import io.github.evertoncnsouza.rest.dto.CupomRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
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

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<Void> update(@PathVariable Long id, @Valid @RequestBody CupomRequest request) {
        Cupom cupom = manager.find(Cupom.class, id);
        Cupom cupomUpdate = request.toModel();
        cupomUpdate.setId(cupom.getId());
        manager.merge(cupomUpdate);

        return ResponseEntity.ok().build();
    }
}