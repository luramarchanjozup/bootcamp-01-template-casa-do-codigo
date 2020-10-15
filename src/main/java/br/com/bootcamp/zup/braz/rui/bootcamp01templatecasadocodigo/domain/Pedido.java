package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
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
@Table(name = "t_pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @NotNull
    @Valid
    private Compra compra;
    @ElementCollection
    @Size(min = 1)
    private Set<ItemCompra> itens = new HashSet<>();

    public Pedido(@NotNull @Valid Compra compra, @Size(min = 1)Set<ItemCompra> itens){
        Assert.isTrue(!itens.isEmpty(), "Todo pedido deve ter pelo menos um item.");
        this.compra = compra;
        this.itens.addAll(itens);
    }

    public boolean totalIgual(@Positive @NotNull BigDecimal total) {
        BigDecimal totalPedido = itens.stream().map(ItemCompra::valorTotal).reduce(BigDecimal.ZERO, (atual, proximo) -> atual.add(proximo));

        return totalPedido.doubleValue() == total.doubleValue();
    }
}
