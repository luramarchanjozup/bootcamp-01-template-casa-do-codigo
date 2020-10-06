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

    @GetMapping("/{id}")
    public ResponseEntity<ShopDto> shopDetails(@PathVariable Long id){

        // +1
        ShopPrice shop = entityManager.find(ShopPrice.class, id);

        // +1
        return ResponseEntity.ok(new ShopDto(shop));

    }

    @PostMapping("/user-data")
    @Transactional
    public ResponseEntity<ShopDto> addShopUserData(@RequestBody @Valid ShopDataForm shopDataForm){

        Shop shop = shopDataForm.toEntity();

        // +1
        entityManager.persist(shop);

        return ResponseEntity.ok().build();

    }

    @PostMapping("/finish")
    @Transactional
    public ResponseEntity<ShopDto> addFinalShopCart(
            @RequestBody @Valid ShopPriceForm shopPriceForm){

        ShopPrice shopCart = shopPriceForm.toEntity();

        // +1
        entityManager.persist(shopCart);

        // +1
        return ResponseEntity.ok(new ShopDto(shopCart));

    }

    @PutMapping("/apply-coupon/{id}/{couponId}")
    public ResponseEntity<ShopDto> applyCoupon(@PathVariable Long couponId,
      @PathVariable Long id)
    {

        // + 1
        ShopPrice shop = couponApplyService.couponApplication(couponId, id);

                                        // + 1
        return ResponseEntity.ok(new ShopDto(shop));

    }
}
