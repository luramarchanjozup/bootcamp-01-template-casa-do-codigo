package br.com.zup.bootcamp.controller.model;

import br.com.zup.bootcamp.controller.validator.annotation.Exist;
import br.com.zup.bootcamp.domain.model.Buyer;
import br.com.zup.bootcamp.domain.model.Coupon;
import br.com.zup.bootcamp.domain.model.Purchase;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;

// Intrinsic charge = 2
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

    public String getCoupon() {
        return coupon;
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

        return purchase;
    }
}
