package io.github.evertoncnsouza.rest.controller;

import io.github.evertoncnsouza.domain.entity.Pais;
import io.github.evertoncnsouza.rest.dto.PaisRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("api/paises")
public class PaisController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    //@ResponseStatus(HttpStatus.CREATED) Comentado para retornar 200;
    public String save (@RequestBody @Valid PaisRequest request) {
        Pais pais = new Pais(request.getNome());
        manager.persist(pais);
        return pais.toString();
    }
}
