package com.casadocodigo.casaDoCodigo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Cart {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Integer total;
    @NotNull @OneToMany(cascade = {CascadeType.ALL})
    private List<CartItem> items;

    @Deprecated
    public Cart(){}

    public Cart(Integer total, List<CartItem> items) {
        this.total = total;
        this.items = items;
    }

    public Integer getTotal() {
        return this.total;
    }

    public List<CartItem> getItems() {
        return this.items;
    }

}
