package br.com.casadocodigo.services;

import br.com.casadocodigo.models.Coupon;
import br.com.casadocodigo.models.Shop;
import br.com.casadocodigo.models.ShopPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.OffsetDateTime;

@Service
public class CouponApplyService {

    @Autowired
    private EntityManager entityManager;

    //+1
    @Transactional                      //+1           //+1
    public ShopPrice couponApplication(Long shopId, Long couponId){

        //+1
        Coupon coupon = entityManager.find(Coupon.class, couponId);

        //+1
        ShopPrice shop = entityManager.find(ShopPrice.class, shopId);

        //+1
        shop.setTotalWithDiscount(shop.getTotal() * coupon.getDiscount());

        entityManager.persist(shop);

        return shop;

    }
}
