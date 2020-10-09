package com.casadocodigo.casaDoCodigo.controllers.form;

import java.util.List;

public class CartForm {
    private Integer total;
    private String coupon;
    private List<CartItemsForm> items;

    public Integer getTotal() {
        return this.total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getCoupon() {
        return this.coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    public List<CartItemsForm> getItems() {
        return this.items;
    }

    public void setItems(List<CartItemsForm> items) {
        this.items = items;
    }

}
