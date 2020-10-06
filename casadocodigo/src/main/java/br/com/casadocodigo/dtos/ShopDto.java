package br.com.casadocodigo.dtos;

import br.com.casadocodigo.models.Book;
import br.com.casadocodigo.models.Shop;
import br.com.casadocodigo.models.ShopPrice;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

public class ShopDto {

    private Double total;

    private Double totalWithDiscount;

    public ShopDto(ShopPrice shop){

        this.total = shop.getTotal();
        this.totalWithDiscount = shop.getTotalWithDiscount();

    }

    public Double getTotal() {
        return total;
    }

    public Double getTotalWithDiscount() {
        return totalWithDiscount;
    }
}
