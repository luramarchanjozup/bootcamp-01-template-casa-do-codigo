package br.com.zup.treinocasadocodigo.controllers;

import br.com.zup.treinocasadocodigo.entities.pais.Pais;
import br.com.zup.treinocasadocodigo.entities.pais.PaisNovoRequest;
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
@RequestMapping("/paises")
public class PaisController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    //1
    public String cadastroPais(@RequestBody @Valid PaisNovoRequest novoPais) {
        //1
        Pais pais = novoPais.toModel();
        manager.persist(pais);
        return pais.toString();
    }
}
