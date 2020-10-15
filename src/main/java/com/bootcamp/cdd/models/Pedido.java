package com.bootcamp.cdd.models;

import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    @NotNull
    @Valid
    private Shopping compra;
    @ElementCollection
    @Size(min = 1)
    private Set<Item> items = new HashSet<>();

    public Pedido(@NotNull Shopping compra, @Size(min = 1) Set<Item> items) {
        Assert.isTrue(!items.isEmpty(), "O item não pode estar nulo");
        this.compra = compra;
        this.items.addAll(items);
    }


    public boolean totalIgual (@Positive @NotNull BigDecimal total) {
        BigDecimal pedido = items.stream().map(Item::total).reduce(BigDecimal.ZERO, BigDecimal::add);
        return pedido.doubleValue() == total.doubleValue();
    }

    public long getId() {
        return id;
    }

    public Set<Item> getItems() {
        return items;
    }
}
