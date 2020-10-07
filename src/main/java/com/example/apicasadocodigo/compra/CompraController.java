package com.example.apicasadocodigo.compra;

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
    private EstadoPertenceAPaisValidator estadoPertenceAPaisValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(new DocumentoValidator(), estadoPertenceAPaisValidator);
    }

    @PostMapping
    @Transactional
    public String efetivarCompra(@Valid @RequestBody NovaCompraRequest request) {
        Compra novaCompra = request.toModel(manager);
        manager.persist(novaCompra);
        return "A compra de id " + novaCompra.getId() + " foi efetivada.";
    }
}