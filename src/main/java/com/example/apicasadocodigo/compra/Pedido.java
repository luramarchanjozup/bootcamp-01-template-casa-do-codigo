package com.example.apicasadocodigo.compra;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    private @OneToOne @NotNull @Valid Compra compra;
    @Embedded
    private @ElementCollection @Size(min = 1) Set<ItemCarrinho> itens = new HashSet<>();

    @Deprecated
    public Pedido() {
    }

    public Pedido(@NotNull @Valid Compra compra, @Size(min = 1) Set<ItemCarrinho> itens) {
        this.compra = compra;
        this.itens.addAll(itens);
    }

    public BigDecimal calcularTotal() {
        return itens.stream().map(itemCarrinho -> itemCarrinho.total()).reduce(new BigDecimal(0), BigDecimal::add);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Set<ItemCarrinho> getItens() {
        return itens;
    }

    public void setItens(Set<ItemCarrinho> itens) {
        this.itens = itens;
    }
}