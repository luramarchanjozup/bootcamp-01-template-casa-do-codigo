package br.com.casadocodigo.controllers;

import br.com.casadocodigo.dtos.ShopDto;
import br.com.casadocodigo.models.Shop;
import br.com.casadocodigo.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class ShopController {

    @Autowired
    private UserServices userServices;


    @PostMapping("/{userId}/{bookId}")
    public ResponseEntity<ShopDto> addBook(@PathVariable Long bookId, @PathVariable Long userId){

        Shop shop = userServices.addToCart(bookId, userId);

        if(shop != null) {
            return ResponseEntity.ok(new ShopDto(shop));
        }

        return ResponseEntity.notFound().build();

    }

    @PutMapping("/{userId}/{couponId}")
    public ResponseEntity<ShopDto> applyCoupon(@PathVariable Long couponId, @PathVariable Long userId){

        Shop shop = userServices.couponApplication(couponId, userId);

        if(shop != null) {
            return ResponseEntity.ok(new ShopDto(shop));
        }

        return ResponseEntity.notFound().build();

    }
}
