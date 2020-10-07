package br.com.zup.treinocasadocodigo.controllers;

import br.com.zup.treinocasadocodigo.entities.compra.Compra;
import br.com.zup.treinocasadocodigo.entities.compra.CompraRequest;
import br.com.zup.treinocasadocodigo.entities.compra.ItensCompra;
import br.com.zup.treinocasadocodigo.entities.compra.ItensCompraRequest;
import br.com.zup.treinocasadocodigo.validators.EstadoValidador;
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
import java.util.stream.Collectors;

/**
 * Contagem de carga intrínseca da classe: 1
 */

@RestController
public class CompraController {

    @Autowired
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
        List<ItensCompraRequest> listaItensRequest = dadosComprador.getPedido().getItens();

        //2
        List<ItensCompra> listaItens = listaItensRequest.stream()
                .map(itemRequest -> itemRequest.toModel(manager))
                .collect(Collectors.toList());
        listaItens.forEach(manager::persist);

        //1
        Compra compra = dadosComprador.toModel(manager, listaItens);
        manager.persist(compra);
        return compra.toString();
    }
}
