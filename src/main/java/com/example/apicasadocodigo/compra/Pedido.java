package com.example.apicasadocodigo.compra;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private @OneToOne @NotNull @Valid Compra compra;
    private @ElementCollection @Size(min = 1) Set<ItemCarrinho> itens = new HashSet<>();

    @Deprecated
    public Pedido() {
    }

    public Pedido(@NotNull @Valid Compra compra, @Size(min = 1) Set<ItemCarrinho> itens) {
        this.compra = compra;
        this.itens.addAll(itens);
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