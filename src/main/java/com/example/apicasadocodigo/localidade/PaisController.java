package com.example.apicasadocodigo.localidade;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/paises")
public class PaisController {
    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public String criarPais(@Valid @RequestBody NovoPaisRequest request) {
        Pais novoPais = request.toModel();
        manager.persist(novoPais);
        return "O país " + novoPais.getNome() + " foi cadastrado.";
    }
}
