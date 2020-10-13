package br.com.zup.treinocasadocodigo.controllers;

import br.com.zup.treinocasadocodigo.entities.estado.Estado;
import br.com.zup.treinocasadocodigo.entities.estado.EstadoNovoRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

/**
 * Contagem de carga intrínseca da classe: 2
 */

@RestController
@RequestMapping("/estados")
public class EstadoConrtoller {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    //1
    public String cadastroEstado(@RequestBody @Valid EstadoNovoRequest novoEstado) {
        //1
        Estado estado = novoEstado.toModel(manager);
        manager.persist(estado);
        return estado.toString();
    }
}
