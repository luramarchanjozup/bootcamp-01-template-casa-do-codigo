package br.com.treino.casadocodigo.model;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Set;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private @Positive BigDecimal total;
    @ElementCollection
    private @Size(min = 1) Set<ItemPedido> itemPedidos;

    @OneToOne
    private @Valid Compra compra;

    @Deprecated
    public Pedido(){}

    public Pedido(Set<ItemPedido> itemPedidos) {
        this.itemPedidos = itemPedidos;
    }

    public Long getId() { return id; }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public Set<ItemPedido> getItemPedidos() {
        return itemPedidos;
    }

    public void calcularTotalPedido(){
        this.total = itemPedidos.stream().map(i -> i.valorTotal()).reduce(
                BigDecimal.ZERO, (s1, s2) -> s1.add(s2));
    }

}
