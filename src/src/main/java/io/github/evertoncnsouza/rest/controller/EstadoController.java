package io.github.evertoncnsouza.rest.controller;

import io.github.evertoncnsouza.domain.entity.Estado;
import io.github.evertoncnsouza.rest.dto.EstadoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.persistence.EntityManager;
import javax.validation.Valid;

@RestController
@RequestMapping("api/estados")

public class EstadoController {

    @Autowired
    private EntityManager manager;

    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED) Comentado para retornar 200;
    @Transactional
    public String save(@RequestBody @Valid EstadoRequest request){
        Estado estado = request.toModel(manager);
        manager.persist(estado);
        return estado.toString();
    }

}
