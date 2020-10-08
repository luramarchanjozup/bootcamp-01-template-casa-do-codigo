package br.com.zup.treinocasadocodigo.controllers;

import br.com.zup.treinocasadocodigo.entities.compra.Compra;
import br.com.zup.treinocasadocodigo.entities.compra.CompraRequest;
import br.com.zup.treinocasadocodigo.entities.compra.ItensCompra;
import br.com.zup.treinocasadocodigo.validators.validarcompras.EstadoValidador;
import br.com.zup.treinocasadocodigo.validators.validarcompras.TotalValorValidador;
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
import java.util.List;

/**
 * Contagem de carga intrínseca da classe: 6
 */

@RestController
public class CompraController {

    @Autowired
    //1
    private EstadoValidador estadoValidador;

    @Autowired
    //1
    private TotalValorValidador totalValorValidador;

    @PersistenceContext
    private EntityManager manager;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(estadoValidador, totalValorValidador);
    }

    @PostMapping("/compra")
    @Transactional
    //1
    public String dadosComprador(@RequestBody @Valid CompraRequest dadosComprador) {

        //1
        List<ItensCompra> itens = dadosComprador.ItenstoModel(manager);
        //1
        itens.forEach(manager::persist);

        //1
        Compra compra = dadosComprador.toModelSemItens(manager);
        compra.setListaItens(itens);
        manager.persist(compra);
        return compra.toString();
    }
}
