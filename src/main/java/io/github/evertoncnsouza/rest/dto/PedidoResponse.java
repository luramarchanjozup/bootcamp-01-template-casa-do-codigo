package io.github.evertoncnsouza.rest.dto;

import io.github.evertoncnsouza.domain.entity.Pedido;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PedidoResponse {


    private BigDecimal total;
    private List<PedidoItemResponse> itens = new ArrayList<>();

    public PedidoResponse(Pedido pedido) {
        total = pedido.getTotal();
        pedido.getItens().forEach( item -> itens.add(new PedidoItemResponse(item)));
    }

    public List<PedidoItemResponse> getItens() {
        return itens;
    }

    public BigDecimal getTotal() {
        return total;
    }

}
