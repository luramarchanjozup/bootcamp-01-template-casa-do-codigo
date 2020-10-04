package br.com.casadocodigo.services;

import br.com.casadocodigo.models.Coupon;
import br.com.casadocodigo.models.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Service
public class CouponApplyService {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Shop couponApplication(Long shopId, Long couponId){

        //+1
        Coupon coupon = entityManager.find(Coupon.class, couponId);

        //+1
        Shop shop = entityManager.find(Shop.class, shopId);

        //+1
        shop.setTotalWithDiscount(shop.getTotal() * coupon.getDiscount());

        entityManager.persist(shop);

        return shop;

    }
}
