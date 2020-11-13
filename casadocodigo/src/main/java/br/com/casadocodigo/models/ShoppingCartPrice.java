package br.com.casadocodigo.models;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ShoppingCartPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Positive
    private Double total;

    @Positive
    private Double totalWithDiscount;

    @ElementCollection
    private List<Item> items = new ArrayList<>();

    @Deprecated
    public ShoppingCartPrice(){};

    public ShoppingCartPrice(@Positive Double total, List<Item> items) {
        this.total = total;
        this.items = items;
    }

    public void applyDiscount(Coupon coupon){
        this.totalWithDiscount = this.total * coupon.getDiscount();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotal() {
        return total;
    }

    public Double getTotalWithDiscount() {
        return totalWithDiscount;
    }

    public void setTotalWithDiscount(Double totalWithDiscount) {
        this.totalWithDiscount = totalWithDiscount;
    }

}
