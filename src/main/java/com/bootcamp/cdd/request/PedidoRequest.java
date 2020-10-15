package com.bootcamp.cdd.request;

import com.bootcamp.cdd.models.Item;
import com.bootcamp.cdd.models.Pedido;
import com.bootcamp.cdd.models.Shopping;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PedidoRequest {
    @Positive
    @NotNull
    private BigDecimal total;
    @Size(min = 1, message = "é necessario pelo menos um item")
    @Valid
    private List<ItemRequest> itens = new ArrayList<>();

    public PedidoRequest(@Positive @NotNull BigDecimal total, @Size(min = 1, message = "é necessario pelo menos um item") @Valid List<ItemRequest> itens) {
        super();
        this.total = total;
        this.itens = itens;
    }

    public List<ItemRequest> getItemRequests() {
        return itens;
    }

    public Function<Shopping, Pedido> toModel(EntityManager manager) {
        Set<Item> itensCalculados = itens.stream().map(item -> item.toModel(manager)).collect(Collectors.toSet());
        return (compra) -> {
            Pedido pedido = new Pedido(compra, itensCalculados);
            Assert.isTrue(pedido.totalIgual(total), "O total dos valores não corresponde ao valor real");
            return pedido;
        };
    }
}
