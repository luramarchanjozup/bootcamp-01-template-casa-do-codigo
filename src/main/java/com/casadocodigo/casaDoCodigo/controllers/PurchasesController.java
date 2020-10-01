package com.casadocodigo.casaDoCodigo.controllers;

import java.net.URI;

import javax.validation.Valid;

import com.casadocodigo.casaDoCodigo.controllers.dto.PurchaseDto;
import com.casadocodigo.casaDoCodigo.controllers.form.PurchaseForm;
import com.casadocodigo.casaDoCodigo.services.PurchasesServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/purchase")
public class PurchasesController {
    
    @Autowired
    private PurchasesServices purchasesServices;

    @PostMapping
    public ResponseEntity<PurchaseDto> createPurchase(@RequestBody @Valid PurchaseForm form, UriComponentsBuilder uriBuilder) {
        PurchaseDto purchase = purchasesServices.createPurchase(form);
        URI uri = uriBuilder.path("purchase/{id}").buildAndExpand(purchase.getId()).toUri();
        return ResponseEntity.created(uri).body(purchase);
    }
}
