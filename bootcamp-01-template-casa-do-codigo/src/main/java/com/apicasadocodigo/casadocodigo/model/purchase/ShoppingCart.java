package com.apicasadocodigo.casadocodigo.model.purchase;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.List;


public class ShoppingCart {

    @NotNull
    @Positive
    private BigDecimal total;

    @NotEmpty//NotEmpty também valida coleções
    @NotNull
    private List<Item> items;//1

    public ShoppingCart(@NotNull @Positive BigDecimal total, @NotEmpty @NotNull List<Item> items) {
        this.total = total;
        this.items = items;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
