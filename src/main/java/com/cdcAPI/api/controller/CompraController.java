package com.cdcAPI.api.controller;

import com.cdcAPI.api.model.Request.CompraRequest;
import com.cdcAPI.api.model.Response.CompraResponse;
import com.cdcAPI.model.Compra;
import com.cdcAPI.validator.ValidarEstadoPertencePais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

//Complexidade = 6
@RestController
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    EntityManager manager;

    @Autowired
    //1
    private ValidarEstadoPertencePais validarEstadoPertencePais;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(validarEstadoPertencePais);
    }

    @PostMapping
    @Transactional
    //2 Compra Request
    public ResponseEntity<Void> comprar(@Valid @RequestBody CompraRequest compraRequest) throws Exception {
        //3 compra
        Compra compra = compraRequest.toModel(manager);
        //4
        if ((compra.getCliente().getDocumento().length()) != 11 && (compra.getCliente().getDocumento().length()) != 14) {
            throw new Exception("Compra não pode ser efetuada. Documento inválido");
        }
        manager.persist(compra);
        String urlCreated = "/compras/" + compra.getId();

        return ResponseEntity.created(URI.create(urlCreated)).build();
    }

    @GetMapping("/{compraId}")
    @Transactional
    //5 Compra response
    public ResponseEntity<CompraResponse> detalhesCompra(@PathVariable Long compraId) throws Exception {
        Compra compra = manager.find(Compra.class, compraId);
        //6
        if (compra == null) throw new Exception("Compra não existe.");
        CompraResponse compraResponse = new CompraResponse(compra);

        return ResponseEntity.ok(compraResponse);
    }

}
