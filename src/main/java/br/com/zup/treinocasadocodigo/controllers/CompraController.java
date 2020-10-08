package br.com.zup.treinocasadocodigo.controllers;

import br.com.zup.treinocasadocodigo.entities.compra.Compra;
import br.com.zup.treinocasadocodigo.entities.compra.CompraRequest;
import br.com.zup.treinocasadocodigo.validators.validarcompras.EstadoValidador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

/**
 * Contagem de carga intrínseca da classe: 4
 */

@RestController
public class CompraController {

    @Autowired
    //1
    private EstadoValidador estadoValidador;

    @PersistenceContext
    private EntityManager manager;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(estadoValidador);
    }

    @PostMapping("/compra")
    @Transactional
    //1
    public String dadosComprador(@RequestBody @Valid CompraRequest dadosComprador) {

        //1
        dadosComprador.ItenstoModel(manager).forEach(manager::persist);

        //1
        Compra compra = dadosComprador.toModel(manager);
        manager.persist(compra);
        return compra.toString();
    }
}
