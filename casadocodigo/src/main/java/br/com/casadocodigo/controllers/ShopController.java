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

    // +1
    @Autowired
    private CouponApplyService couponApplyService;

    @Autowired
    private EntityManager entityManager;

    @GetMapping("/{id}/{userDataId}")
    public ResponseEntity<ShopDto> shopDetails(@PathVariable Long id, @PathVariable Long userDataId){

        // +1
        ShopPrice shop = entityManager.find(ShopPrice.class, id);

        //+ 1
        Shop userData = entityManager.find(Shop.class, userDataId);

        // +1
        return ResponseEntity.ok(new ShopDto(shop,userData));

    }

    @PostMapping("/user-data")
    @Transactional
    public ResponseEntity<?> addShopUserData(@RequestBody @Valid ShopDataForm shopDataForm){

        // +1
        Shop shop = shopDataForm.toEntity();

        entityManager.persist(shop);

        return ResponseEntity.ok().build();

    }

    @PostMapping("/finish")
    @Transactional
    public ResponseEntity<?> addFinalShopCart(
            @RequestBody @Valid ShopPriceForm shopPriceForm){

        // +1
        ShopPrice shopCart = shopPriceForm.toEntity();

        entityManager.persist(shopCart);

        // +1
        return ResponseEntity.ok().build();

    }

    @PutMapping("/apply-coupon/{id}/{couponId}")
    public ResponseEntity<?> applyCoupon(@PathVariable Long couponId,
      @PathVariable Long id)
    {

        // + 1
        ShopPrice shop = couponApplyService.couponApplication(couponId, id);

                                        // + 1
        return ResponseEntity.ok().build();

    }
}
