package com.example.apicasadocodigo.fluxocompra.pedido;

import com.example.apicasadocodigo.fluxocompra.compra.Compra;
import com.example.apicasadocodigo.fluxocompra.itemcarrinho.ItemCarrinho;
import com.example.apicasadocodigo.fluxocompra.itemcarrinho.NovoItemCarrinhoRequest;
import com.example.apicasadocodigo.fluxocompra.pedido.Pedido;

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

public class NovoPedidoRequest {
    @Positive
    @NotNull
    private BigDecimal total;
    @Size(min = 1)
    @Valid
    private List<NovoItemCarrinhoRequest> itens = new ArrayList<>();

    public NovoPedidoRequest(@Positive @NotNull BigDecimal total,
                             @Size(min = 1) @Valid List<NovoItemCarrinhoRequest> itens) {
        this.total = total;
        this.itens = itens;
    }

    public Function<Compra, Pedido> toModel(EntityManager manager) {
        Set<ItemCarrinho> itensSelecionados = itens.stream().map(item -> item.toModel(manager)).collect(Collectors.toSet());
        return (compra) -> {
            Pedido pedido = new Pedido(compra, itensSelecionados);
            return pedido;
        };
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<NovoItemCarrinhoRequest> getItens() {
        return itens;
    }

    public void setItens(List<NovoItemCarrinhoRequest> itens) {
        this.itens = itens;
    }
}
