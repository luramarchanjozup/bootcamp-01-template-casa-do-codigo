package br.com.casadocodigo.controllers;
import br.com.casadocodigo.dtos.ShopDto;
import br.com.casadocodigo.models.Shop;
import br.com.casadocodigo.repositories.ShopRepository;
import br.com.casadocodigo.services.AddToCartService;
import br.com.casadocodigo.services.CouponApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;

@RestController
@RequestMapping("/shop")
public class ShopController {

    // + 1
    @Autowired
    private AddToCartService addToCartService;

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

        return ResponseEntity.notFound().build();

    }

    @PutMapping("/addBook/{shopId}/{bookId}")
    public ResponseEntity<ShopDto> addBook(@PathVariable Long bookId, @PathVariable Long shopId){

        // + 1
        Shop shop = addToCartService.addToCart(bookId, shopId);

        // + 1
        if(shop != null) {
                                            // + 1
            return ResponseEntity.ok(new ShopDto(shop));

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
        return ResponseEntity.notFound().build();

    }
}
