package br.com.casadocodigo.controller;


import br.com.casadocodigo.model.NovoPaisRequest;
import br.com.casadocodigo.model.Pais;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class PaisController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/api/paises")
    @Transactional
    public String criaPais(@Valid @RequestBody NovoPaisRequest novoPaisRequest){
        Pais novoPais = new Pais(novoPaisRequest.getNome());
        entityManager.persist(novoPais);
        return novoPais.toString();
    }
}
