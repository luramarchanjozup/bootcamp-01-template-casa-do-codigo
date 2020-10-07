package br.com.casadocodigo.controllers;
import br.com.casadocodigo.dtos.ShopDto;
import br.com.casadocodigo.forms.ShopDataForm;
import br.com.casadocodigo.forms.ShopPriceForm;
import br.com.casadocodigo.models.Coupon;
import br.com.casadocodigo.models.ShoppingCartPrice;
import br.com.casadocodigo.models.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/shop")
public class ShopController {


    @Autowired
    private EntityManager entityManager;

    @GetMapping("/{id}/{userDataId}")
    public ResponseEntity<ShopDto> shopDetails(@PathVariable Long id, @PathVariable Long userDataId){

        // +1
        return ResponseEntity.ok(
                new ShopDto(entityManager.find(UserData.class, userDataId), entityManager.find(ShoppingCartPrice.class, id))
        );

    }

    @PostMapping("/user-data")
    @Transactional
    public ResponseEntity<?> addShopUserData(@RequestBody @Valid ShopDataForm shopDataForm){

        // +1
        UserData userData = shopDataForm.toEntity();

        entityManager.persist(userData);

        return ResponseEntity.ok().build();

    }

    @PostMapping("/finish")
    @Transactional
    public ResponseEntity<?> addFinalShopCart(
            @RequestBody @Valid ShopPriceForm shopPriceForm){

        // +1
        ShoppingCartPrice userDataCart = shopPriceForm.toEntity();

        entityManager.persist(userDataCart);

        return ResponseEntity.ok().build();

    }

    @Transactional
    @PutMapping("/apply-coupon/{id}/{couponId}")
    public ResponseEntity<?> applyCoupon(@PathVariable Long couponId, @PathVariable Long id)
    {
        // +1
        ShoppingCartPrice shoppingCartPrice = entityManager
                .find(ShoppingCartPrice.class, id);

        // +1                            // +1
        shoppingCartPrice.applyDiscount(entityManager
                .find(Coupon.class, couponId));

        entityManager.persist(shoppingCartPrice);

        return ResponseEntity.ok().build();

    }
}
