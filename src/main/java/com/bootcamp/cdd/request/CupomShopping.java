package com.bootcamp.cdd.request;

import javax.validation.constraints.NotNull;

public class CupomShopping {
    @NotNull(message = "o id da compra precisa ser enviado")
    private long shoppingId;
    @NotNull(message = "o id do cupom precisa ser enviado")
    private long cupomId;

    public CupomShopping(@NotNull(message = "o id da compra precisa ser enviado") long shoppingId, @NotNull(message = "o id do cupom precisa ser enviado") long cupomId) {
        this.shoppingId = shoppingId;
        this.cupomId = cupomId;
    }

    public long getShoppingId() {
        return shoppingId;
    }

    public long getCupomId() {
        return cupomId;
    }
}
