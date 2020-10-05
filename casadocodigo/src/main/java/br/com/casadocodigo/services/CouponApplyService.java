package br.com.casadocodigo.services;

import br.com.casadocodigo.models.Coupon;
import br.com.casadocodigo.models.Shop;
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
    public Shop couponApplication(Long shopId, Long couponId){

        //+1
        Coupon coupon = entityManager.find(Coupon.class, couponId);

        //+1
        Shop shop = entityManager.find(Shop.class, shopId);

        //+1
        if(coupon.getValidate().isBefore(OffsetDateTime.now())){

            //+1
            shop.setTotalWithDiscount(shop.getTotal() * coupon.getDiscount());

            entityManager.persist(shop);

            return shop;

        }

        return null;

    }
}
