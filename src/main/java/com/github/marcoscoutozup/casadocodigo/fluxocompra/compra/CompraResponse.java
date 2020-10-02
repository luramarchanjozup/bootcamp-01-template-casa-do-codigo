package com.github.marcoscoutozup.casadocodigo.fluxocompra.compra;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.marcoscoutozup.casadocodigo.fluxocompra.cliente.ClienteResponse;
import com.github.marcoscoutozup.casadocodigo.fluxocompra.cupom.CupomResponse;
import com.github.marcoscoutozup.casadocodigo.fluxocompra.pedido.PedidoResponse;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompraResponse {

    //1
    private ClienteResponse cliente;

    //2
    private PedidoResponse pedido;

    //3
    private CupomResponse cupom;
    private BigDecimal totalComDesconto;
                            //4
    public CompraResponse(Compra compra) {
        this.cliente = new ClienteResponse(compra.getCliente());
        this.pedido = new PedidoResponse(compra.getPedido());
        //5
        if(compra.getCupom() != null){
            this.cupom = new CupomResponse(compra.getCupom());
            this.totalComDesconto = calcularValorComDesconto(compra);
        }
    }

    private BigDecimal calcularValorComDesconto(Compra compra){
        BigDecimal percentualDeDesconto = new BigDecimal(compra.getCupom().getPercentual()).divide(new BigDecimal(100));
        BigDecimal valorDoDesconto = compra.getPedido().getTotal().multiply(percentualDeDesconto);
        BigDecimal valorTotalComDesconto = compra.getPedido().getTotal().subtract(valorDoDesconto);
        return valorTotalComDesconto.setScale(2);
    }

    public ClienteResponse getCliente() {
        return cliente;
    }

    public PedidoResponse getPedido() {
        return pedido;
    }

    public CupomResponse getCupom() {
        return cupom;
    }

    public BigDecimal getTotalComDesconto() {
        return totalComDesconto;
    }
}
