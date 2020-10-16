package com.bootcamp.cdd.controllers;

import com.bootcamp.cdd.models.Cupom;
import com.bootcamp.cdd.models.Shopping;
import com.bootcamp.cdd.request.CupomShopping;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

@RestController
@RequestMapping(value = "/api/v1/shopping")
public class addCupomCompraController {
    @PersistenceContext
    private EntityManager manager;

    @PostMapping(value = "/{idCompra}/addCupom")
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public Shopping addCupomShopping (@Valid @RequestBody CupomShopping request) {
        Shopping compra =  manager.find(Shopping.class, request.getShoppingId());
        Cupom cupom = manager.find(Cupom.class, request.getCupomId());
        Assert.state(cupom.getDataValidade().isAfter(LocalDate.now()), "a data de validade desse cupom está vencida");
        double porcentagem = cupom.getPorcentagem() / 100;
        BigDecimal valorFinal = compra.getValorTotal().subtract(compra.getValorTotal().multiply(new BigDecimal(porcentagem)));
        compra.setCupom(cupom.getCodigo(), valorFinal.setScale(2, RoundingMode.HALF_EVEN));
        return compra;
    }
}
