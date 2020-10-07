package com.example.apicasadocodigo.cupom;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/cupons")
public class CupomController {
    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public String criarCupon(@Valid @RequestBody NovoCupomRequest request) {
        Cupom novoCupom = request.toModel();
        manager.persist(novoCupom);
        return "O cupom de código " + novoCupom.getCodigo() + " foi criado.";
    }
}
