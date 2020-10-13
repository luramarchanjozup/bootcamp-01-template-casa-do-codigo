package com.example.apicasadocodigo.fluxocompra.compra;

import com.example.apicasadocodigo.fluxocompra.cupom.CupomRepository;
import com.example.apicasadocodigo.fluxocompra.validadores.CupomValidator;
import com.example.apicasadocodigo.fluxocompra.validadores.DocumentoValidator;
import com.example.apicasadocodigo.fluxocompra.validadores.EstadoPertenceAPaisValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/compras")
public class CompraController {
    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private CupomRepository cupomRepository;

    @Autowired
    private EstadoPertenceAPaisValidator estadoPertenceAPaisValidator;

    @Autowired
    private CupomValidator cupomValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(new DocumentoValidator(), estadoPertenceAPaisValidator, cupomValidator);
    }

    @PostMapping
    @Transactional
    public String efetivarCompra(@Valid @RequestBody NovaCompraRequest request) {
        Compra novaCompra = request.toModel(manager, cupomRepository);
        manager.persist(novaCompra);
        return "A compra de id " + novaCompra.getId() + " foi efetivada.";
    }
}