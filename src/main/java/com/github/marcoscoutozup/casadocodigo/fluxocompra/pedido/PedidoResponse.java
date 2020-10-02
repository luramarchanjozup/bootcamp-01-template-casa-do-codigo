package com.github.marcoscoutozup.casadocodigo.fluxocompra.pedido;

import com.github.marcoscoutozup.casadocodigo.fluxocompra.itempedido.ItemPedido;
import com.github.marcoscoutozup.casadocodigo.fluxocompra.itempedido.ItemPedidoResponse;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class PedidoResponse {

    private BigDecimal total;
                    //1
    private List<ItemPedidoResponse> itens;

                            //2
    public PedidoResponse(Pedido pedido) {
        this.total = pedido.getTotal();
        this.itens = converterListadePedidos(pedido.getItens());
    }

    private List<ItemPedidoResponse> converterListadePedidos(List<ItemPedido> itemPedidos) {
                                            //3
        return itemPedidos.stream().map(ItemPedidoResponse::new).collect(Collectors.toList());
    }

    public BigDecimal getTotal() {
        return total;
    }

    public List<ItemPedidoResponse> getItens() {
        return itens;
    }

}
