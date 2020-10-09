package com.casadocodigo.responses;

import com.casadocodigo.entity.Cart;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CartDetailResponse {
    private ItensDetailResponse itens;

    public CartDetailResponse(Cart cart) {
        itens = new ItensDetailResponse(cart.getItensCart());
    }

    public ItensDetailResponse getItens() {
        return itens;
    }
}
