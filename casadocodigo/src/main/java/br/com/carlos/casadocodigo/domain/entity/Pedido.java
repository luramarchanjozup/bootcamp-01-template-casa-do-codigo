package br.com.carlos.casadocodigo.domain.entity;

import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Valid
    @OneToOne @NotNull
    private Compra compra;

    @ElementCollection
    @Size(min = 1)
    private final Set<ItemPedido> itens = new HashSet<>();

    @Deprecated
    public Pedido(){}

    public Pedido(Compra compra, Set<ItemPedido> itens) {
        Assert.isTrue(!itens.isEmpty(), "todo pedido deve ter pelo menos um item");
        this.compra = compra;
        this.itens.addAll(itens);
    }

    public boolean totalIgual(@Positive BigDecimal total) {
        BigDecimal totalPedido = itens.stream().map(ItemPedido::total).reduce(BigDecimal.ZERO, BigDecimal::add);

        return totalPedido.doubleValue() == total.doubleValue();
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
}
