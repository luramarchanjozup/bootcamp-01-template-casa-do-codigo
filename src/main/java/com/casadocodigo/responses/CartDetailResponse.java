package com.casadocodigo.responses;

import com.casadocodigo.entity.Cart;

public class CartDetailResponse {
    private ItensDetailResponse itens;
    private double total;
    private double totalWithDiscount;

    public CartDetailResponse(Cart cart) {
        itens = new ItensDetailResponse(cart.getItensCart());
        total = cart.getTotal().doubleValue();
        totalWithDiscount = cart.getTotalWithDiscount();
    }

    public ItensDetailResponse getItens() {
        return itens;
    }

    public double getTotal() {
        return total;
    }

    public double getTotalWithDiscount() {
        return totalWithDiscount;
    }
}
