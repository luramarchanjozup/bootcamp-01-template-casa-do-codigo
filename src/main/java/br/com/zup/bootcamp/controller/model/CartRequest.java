package br.com.zup.bootcamp.controller.model;

import br.com.zup.bootcamp.controller.validator.annotation.Exist;
import br.com.zup.bootcamp.domain.model.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

// Intrinsic charge = 6
public class CartRequest {
    @NotNull(message = "Total is mandatory")
    private float total;

    @Exist(message = "Coupon not exist", fieldName = "code", domainClass = Coupon.class)
    private String coupon;

    @NotEmpty(message = "Items must not be empty")
    Collection<@Valid @NotNull(message = "Item must not be null") ItemRequest> items;

    public float getTotal() {
        return total;
    }

    public Collection<ItemRequest> getItems() {
        return items;
    }

    public Optional<String> getCoupon() {
        return Optional.of(this.coupon);
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void setItems(Collection<ItemRequest> items) {
        this.items = items;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    public Purchase convert(Buyer buyer){
        Purchase purchase = new Purchase();
        purchase.setBuyer(buyer);
        purchase.setTotal(this.total);
        buyer.setPurchase(purchase);
        purchase.setItems(this.convertItems(purchase));

        return purchase;
    }

    public Coupon convertCoupon(EntityManager manager, Purchase purchase){
        Coupon coupon;

        if(this.getCoupon().isPresent()){
            Query query = manager.createQuery("select b from " + Coupon.class.getName() + " b where code = :value");
            query.setParameter("value", this.coupon);
            coupon = (Coupon) query.getResultList().get(0);
            purchase.setCoupon(coupon);
            purchase.applyDiscount();
        }else{
            coupon = new Coupon();
            coupon.setPercentage(0);
        }

        return coupon;
    }

    public Collection<Item> convertItems(Purchase purchase) {
        Collection<Item> items = new ArrayList<>();

        for (ItemRequest itemRequest : this.items) {
            Item item = itemRequest.convert();
            item.setPurchase(purchase);
            items.add(item);
        }

        return items;
    }
}
