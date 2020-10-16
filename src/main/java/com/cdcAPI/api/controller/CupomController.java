package com.cdcAPI.api.controller;

import com.cdcAPI.api.model.Request.CupomEditarRequest;
import com.cdcAPI.api.model.Request.CupomRequest;
import com.cdcAPI.model.Cupom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

//Complexidade = 3
//CupomRequest, Cupom, CupomEditar

@RestController
@RequestMapping("/cupons")
public class CupomController {

    @Autowired
    EntityManager manager;

    @PostMapping
    @Transactional
    //1 Cupom Request
    public ResponseEntity<Void> criarCupom(@Valid @RequestBody CupomRequest request) {
        manager.persist(request.toModel());

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{cupomId}")
    @Transactional
    //2 Cupom Editar Request
    public ResponseEntity<Void> editarCupom(@Valid @RequestBody CupomEditarRequest request,
                                            @PathVariable Long cupomId) throws Exception {

        //3 Cupom
        Cupom antigoCupom = manager.find(Cupom.class, cupomId);
        if (antigoCupom == null) throw new Exception("Cupom não encontrado.");

        request.validaDuplicidade(cupomId, manager);

        Cupom novoCupom = request.toModel();
        novoCupom.setId(antigoCupom.getId());

        manager.merge(novoCupom);

        return ResponseEntity.ok().build();
    }

}
