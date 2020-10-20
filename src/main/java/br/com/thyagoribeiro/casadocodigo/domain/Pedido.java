package br.com.thyagoribeiro.casadocodigo.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

// CDD - Total 1

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @NotNull
    private Compra compra; // CDD 1 - Classe Compra

    @Size(min = 1)
    @ElementCollection
    private List<Item> itemList;

    @NotNull
    @Positive
    private BigDecimal total;

    @Deprecated
    public Pedido() {
    }

    public Pedido(@NotNull @Positive BigDecimal total, @Size(min = 1) List<Item> itemList) {
        this.itemList = itemList;
        this.total = total;
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

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
