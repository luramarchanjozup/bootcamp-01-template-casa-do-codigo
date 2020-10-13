package com.casadocodigo.responses;


import com.casadocodigo.entity.Book;
import com.casadocodigo.entity.ItemCart;

import java.util.HashSet;
import java.util.Set;

public class ItensDetailResponse {

    private Set<ItemCart> itens = new HashSet<>();

    public ItensDetailResponse(Set<ItemCart> itensCart) {
        itens = itensCart;
    }

    public Set<ItemCart> getItens() {
        return itens;
    }
}
