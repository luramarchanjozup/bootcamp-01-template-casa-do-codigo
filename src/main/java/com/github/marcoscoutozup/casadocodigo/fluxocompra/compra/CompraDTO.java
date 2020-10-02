package com.github.marcoscoutozup.casadocodigo.fluxocompra.compra;

import com.github.marcoscoutozup.casadocodigo.fluxocompra.cliente.ClienteDTO;
import com.github.marcoscoutozup.casadocodigo.fluxocompra.cupom.Cupom;
import com.github.marcoscoutozup.casadocodigo.fluxocompra.pedido.PedidoDTO;
import com.github.marcoscoutozup.casadocodigo.validator.codigodecupom.CupomValidoParaCompra;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class CompraDTO {

    @NotNull
    @Valid
    private ClienteDTO cliente;

    @NotNull
    @Valid
    private PedidoDTO pedido;

    @CupomValidoParaCompra
    private String cupom;

    public Compra toModel(EntityManager entityManager){
        Compra compra = new Compra(cliente.toModel(entityManager), pedido.toModel());
        TypedQuery<Cupom> query = entityManager.createNamedQuery("findCupomByCodigo", Cupom.class).setParameter("codigo", this.cupom);
        if(!query.getResultList().isEmpty()){
            compra.setCupom(query.getSingleResult());
        }
        return compra;
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

    public String getCupom() {
        return cupom;
    }

    public void setCupom(String cupom) {
        this.cupom = cupom;
    }
}
