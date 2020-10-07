package br.com.casadocodigo.forms;

import br.com.casadocodigo.models.Item;
import br.com.casadocodigo.models.ShoppingCartPrice;
import br.com.casadocodigo.models.UserData;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.List;

public class ShopPriceForm {

    @Positive
    private Double total;

    private List<Item> items;

    public ShopPriceForm(@NotBlank Double total, List<Item> items) {

        this.total = total;

        this.items = items;

    }

    public ShoppingCartPrice toEntity(){

        return new ShoppingCartPrice(total, items);

    }

}
