package br.com.casadocodigo.controllers;

import br.com.casadocodigo.models.ShoppingCart;
import br.com.casadocodigo.repositories.ShoppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/shopping")
public class ShoppingController {

    @Autowired
    private ShoppingRepository shoppingRepository;

    @PostMapping
    public ResponseEntity<ShoppingCart> createShoppingCart(@RequestBody @Valid ShoppingCart shoppingCart){

        if(shoppingCart != null){
            return ResponseEntity.ok(shoppingCart);
        }

        return ResponseEntity.notFound().build();

    }

}
