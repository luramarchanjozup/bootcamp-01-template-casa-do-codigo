package br.com.casadocodigo.controllers;
import br.com.casadocodigo.dtos.ShopDto;
import br.com.casadocodigo.forms.ShopDataForm;
import br.com.casadocodigo.forms.ShopPriceForm;
import br.com.casadocodigo.models.Shop;
import br.com.casadocodigo.models.ShopPrice;
import br.com.casadocodigo.services.CouponApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/shop")
public class ShopController {

    // + 1
    @Autowired
    private CouponApplyService couponApplyService;

    @Autowired
    private EntityManager entityManager;

    @GetMapping("/{shopId}")
    public ResponseEntity<ShopDto> shopDetails(@PathVariable Long shopId){

        // + 1
        Shop shop = entityManager.find(Shop.class, shopId);

        // + 1
        if(shopId != null) {

            // + 1
            return ResponseEntity.ok(new ShopDto(shop));

        }

        return ResponseEntity.badRequest().build();

    }

    @PostMapping("/shoppingCartData")
    @Transactional
    public ResponseEntity<ShopDto> addShopUserData(@RequestBody @Valid ShopDataForm shopDataForm){

        Shop shop = shopDataForm.toEntity();

        // + 1
        if(shop != null) {

            entityManager.persist(shop);
                                            // + 1
            return ResponseEntity.ok(new ShopDto(shop));

        }

        return ResponseEntity.notFound().build();

    }

    @PostMapping("/shoppingCartFinal")
    @Transactional
    public ResponseEntity<ShopPrice> addFinalShopCart(
            @RequestBody @Valid ShopPriceForm shopPriceForm){

        ShopPrice shopCart = shopPriceForm.toEntity();

        // + 1
        if(shopCart != null) {

            entityManager.persist(shopCart);

            // + 1
            return ResponseEntity.ok(shopCart);

        }

        return ResponseEntity.notFound().build();

    }

    @PutMapping("/applyCoupon/{userId}/{couponId}")
    public ResponseEntity<Double> applyCoupon(@PathVariable Long couponId,
      @PathVariable Long userId)
    {
        // + 1
        Shop shop = couponApplyService.couponApplication(couponId, userId);

        // + 1
        if(shop != null) {
                                                // + 1
            return ResponseEntity.ok(shop.getTotalWithDiscount());

        }


        return ResponseEntity.badRequest().build();

    }
}
