package com.example.apicasadocodigo.compra;

import com.example.apicasadocodigo.cupom.CupomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("/compras")
public class CompraController {
    @PersistenceContext
    private EntityManager manager;
    @Autowired
    private CupomRepository cupomRepository;

    @Autowired
    private EstadoPertenceAPaisValidator estadoPertenceAPaisValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(new DocumentoValidator(), estadoPertenceAPaisValidator);
    }

    @PostMapping
    @Transactional
    public String efetivarCompra(@Valid @RequestBody NovaCompraRequest request) {
        Compra novaCompra = request.toModel(manager, cupomRepository);
        manager.persist(novaCompra);
        return "A compra de id " + novaCompra.getId() + " foi efetivada.";
    }
}