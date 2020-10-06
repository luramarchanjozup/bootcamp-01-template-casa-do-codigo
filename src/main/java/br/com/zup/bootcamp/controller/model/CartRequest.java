package br.com.zup.bootcamp.controller.model;

import br.com.zup.bootcamp.domain.model.Buyer;
import br.com.zup.bootcamp.domain.model.Purchase;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;

// Intrinsic charge = 1
public class CartRequest {
    @NotNull(message = "Total is mandatory")
    private float total;

    @NotEmpty(message = "Items must not be empty")
    Collection<@Valid @NotNull(message = "Item must not be null") ItemRequest> items;

    public float getTotal() {
        return total;
    }

    public Collection<ItemRequest> getItems() {
        return items;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void setItems(Collection<ItemRequest> items) {
        this.items = items;
    }

    public Purchase convert(Buyer buyer){
        Purchase purchase = new Purchase();
        purchase.setBuyer(buyer);
        purchase.setTotal(this.total);

        return purchase;
    }
}
