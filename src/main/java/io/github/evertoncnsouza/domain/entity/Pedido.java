package io.github.evertoncnsouza.domain.entity;

import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

//3 PCI's
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private @NotNull @Valid Compra compra;
    //PCI 1;

    private BigDecimal total;

    //PCI 2;
    @Embedded
    @ElementCollection //Mostra que a existência da Classe filha "ItemPedido", não tem sentido sem a classe mãe "Pedido";
    private @Size(min = 1) Set<ItemPedido> itens = new HashSet<>();

    @Deprecated
    public Pedido() {	}

    public Pedido(@NotNull @Valid Compra compra,@NotNull @Positive BigDecimal total,
                  @Size(min = 1) Set<ItemPedido> itens) {
        Assert.notEmpty(itens, "Todo pedido deve ter pelo menos 1 item");
        this.total = total;
        this.itens = itens;
        this.compra = compra;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public Set<ItemPedido> getItens() {
        return itens;
    };

    public boolean totalIgual(@NotNull @Positive BigDecimal total) {
        BigDecimal totalPedido = this.itens.stream().map(ItemPedido::total).reduce(BigDecimal.ZERO, (atual, proximo) -> atual.add(proximo));
        return totalPedido.compareTo(total) == 0;
    }

    @Override
    public String toString() {
        return "Pedido [id=" + id + ", total=" + total + ", itens=" + itens + "]";
    }

}