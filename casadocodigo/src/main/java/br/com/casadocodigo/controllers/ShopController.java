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
@RequestMapping("/api/shop")
public class ShopController {

    private final EntityManager entityManager;

    public ShopController(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @GetMapping("/{id}/{userDataId}")
    public ResponseEntity<ShopDto> shopDetails(@PathVariable Long id, @PathVariable Long userDataId){

        var userData = entityManager.find(UserData.class, userDataId);
        var shoppingCartPrice = entityManager.find(ShoppingCartPrice.class, id);


        return ResponseEntity.ok(new ShopDto(userData,shoppingCartPrice));

    }

    @PostMapping("/user-data")
    @Transactional
    public ResponseEntity<?> addShopUserData(@RequestBody @Valid ShopDataForm shopDataForm){

        var userData = shopDataForm.toEntity();
        entityManager.persist(userData);

        return ResponseEntity.ok().build();

    }

    @PostMapping("/finish")
    @Transactional
    public ResponseEntity<?> addFinalShopCart(@RequestBody @Valid ShopPriceForm shopPriceForm){

        var userDataCart = shopPriceForm.toEntity();
        entityManager.persist(userDataCart);

        return ResponseEntity.ok().build();

    }

    @Transactional
    @PutMapping("/apply-coupon/{id}/{couponId}")
    public ResponseEntity<?> applyCoupon(@PathVariable Long couponId, @PathVariable Long id)
    {

        var shoppingCartPrice = entityManager.find(ShoppingCartPrice.class, id);
        shoppingCartPrice.applyDiscount(entityManager.find(Coupon.class, couponId));
        entityManager.persist(shoppingCartPrice);

        return ResponseEntity.ok().build();

    }
}
