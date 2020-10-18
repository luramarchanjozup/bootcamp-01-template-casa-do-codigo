package io.github.evertoncnsouza.rest.dto;

import io.github.evertoncnsouza.domain.entity.Compra;
import io.github.evertoncnsouza.domain.entity.ItemPedido;
import io.github.evertoncnsouza.domain.entity.Pedido;
import org.springframework.util.Assert;
import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

//2 PCI;
public class PedidoRequest {

    @Positive
    @NotNull
    private BigDecimal total;

    @Size(min=1)
    @Valid
    private List<PedidoItemRequest> itens = new ArrayList<>();
    //PCI 1;

    public PedidoRequest(@NotNull @Positive BigDecimal total, @NotEmpty List<PedidoItemRequest> itens) {
        super();
        this.total = total;
        this.itens = itens;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public List<PedidoItemRequest> getItens() {
        return itens;
    }



    public Function<Compra, Pedido> toModel(EntityManager manager){
        Set<ItemPedido> itensCalculados = itens.stream().map(item -> item.toModel(manager)).collect(Collectors.toSet());
        return (compra) ->{
            Pedido pedido = new Pedido(compra, total, itensCalculados);
            Assert.isTrue(pedido.totalIgual(this.total), "Total do pedido, não reflete o total real");
            return pedido;
        };
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public void setItens(List<PedidoItemRequest> itens) {
        this.itens = itens;
    }
}
