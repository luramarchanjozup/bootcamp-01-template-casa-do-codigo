package com.casadocodigo.casaDoCodigo.controllers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import com.casadocodigo.casaDoCodigo.controllers.dto.CartDetails;
import com.casadocodigo.casaDoCodigo.controllers.dto.ClientCountry;
import com.casadocodigo.casaDoCodigo.controllers.dto.PurchaseDto;
import com.casadocodigo.casaDoCodigo.controllers.form.PurchaseForm;
import com.casadocodigo.casaDoCodigo.model.Cart;
import com.casadocodigo.casaDoCodigo.model.Purchases;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchase")
//6
public class PurchasesController {

    @PersistenceContext
    private EntityManager manager;
    
    @PostMapping
    @Transactional
    public ResponseEntity<PurchaseDto> createPurchase(@RequestBody @Valid PurchaseForm form) {
        CartDetails cartDetails = form.createCart(manager);
        ClientCountry clientCountry = new ClientCountry(manager, form);

        Purchases purchase = new Purchases(form, clientCountry.getState(), clientCountry.getCountry(), 
                            new Cart(cartDetails.getQuantity(), cartDetails.getCartItems()));

        manager.persist(purchase);

        return ResponseEntity.ok().body(
            new PurchaseDto(purchase, cartDetails.getBooks(), cartDetails.getFinalPrice(), 
                            cartDetails.getDiscountedPrice(), cartDetails.getAppliedCoupon()));
    }
}
