package com.github.marcoscoutozup.casadocodigo.fluxocompra.compra;

import com.github.marcoscoutozup.casadocodigo.fluxocompra.cliente.ClienteDTO;
import com.github.marcoscoutozup.casadocodigo.fluxocompra.cupom.AplicarCupomDTO;
import com.github.marcoscoutozup.casadocodigo.fluxocompra.pedido.PedidoDTO;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class CompraDTO {

    @NotNull
    @Valid
    private ClienteDTO cliente;

    @NotNull
    @Valid
    private PedidoDTO pedido;

    private AplicarCupomDTO cupom;

    public Compra toModel(){
        return new Compra(cliente.toModel(), pedido.toModel());
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public PedidoDTO getPedido() {
        return pedido;
    }

    public void setPedido(PedidoDTO pedido) {
        this.pedido = pedido;
    }

    public AplicarCupomDTO getCupom() {
        return cupom;
    }

    public void setCupom(AplicarCupomDTO cupom) {
        this.cupom = cupom;
    }
}
