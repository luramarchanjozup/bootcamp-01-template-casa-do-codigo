package br.com.zup.bootcamp.controller.model;

import br.com.zup.bootcamp.domain.model.Item;
import br.com.zup.bootcamp.domain.model.Purchase;

import java.util.ArrayList;
import java.util.Collection;

// Intrinsic charge = 3
public class PurchaseResponse {
    private String id;
    private float total;
    private float finalPrice;
    private String coupon;
    private Collection<ItemResponse> items;

    public PurchaseResponse(){}

    public PurchaseResponse(Purchase purchase) {
        this.id = purchase.getId();
        this.total = purchase.getTotal();
        this.finalPrice = purchase.getFinalPrice();
        this.coupon = purchase.getCoupon().getCode();
        this.items = new ArrayList<>();
        for (Item item : purchase.getItems()){
            this.items.add(new ItemResponse(item));
        }
    }

    public String getId() {
        return id;
    }

    public float getTotal() {
        return total;
    }

    public float getFinalPrice() {
        return finalPrice;
    }

    public String getCoupon() {
        return coupon;
    }

    public Collection<ItemResponse> getItems() {
        return items;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void setFinalPrice(float finalPrice) {
        this.finalPrice = finalPrice;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    public void setItems(Collection<ItemResponse> items) {
        this.items = items;
    }
}
