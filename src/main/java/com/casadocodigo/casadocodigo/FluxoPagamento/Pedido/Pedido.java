package com.casadocodigo.casadocodigo.FluxoPagamento.Pedido;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.casadocodigo.casadocodigo.FluxoPagamento.Compra.Compra;
import com.casadocodigo.casadocodigo.FluxoPagamento.ItemPedido.ItemPedido;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    private @OneToOne @NotNull @Valid Compra compra;
    @Embedded
    private @ElementCollection @Size(min = 1) Set<ItemPedido> itens = new HashSet<>();

    @Deprecated
    public Pedido() {
    }

    public Pedido(@NotNull @Valid Compra compra, @Size(min = 1) Set<ItemPedido> itens) {
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

    public Set<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(Set<ItemPedido> itens) {
        this.itens = itens;
    }
}