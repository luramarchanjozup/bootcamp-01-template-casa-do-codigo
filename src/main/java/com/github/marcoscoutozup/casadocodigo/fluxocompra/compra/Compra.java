package com.github.marcoscoutozup.casadocodigo.fluxocompra.compra;

import com.github.marcoscoutozup.casadocodigo.fluxocompra.cliente.Cliente;
import com.github.marcoscoutozup.casadocodigo.fluxocompra.cupom.Cupom;
import com.github.marcoscoutozup.casadocodigo.fluxocompra.pedido.Pedido;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
public class Compra {

    @Id
    @GeneratedValue(generator = "uuid4")
    private UUID id;

    @Embedded
    @NotNull
    @Valid
    private Cliente cliente;

    @Embedded
    @NotNull
    @Valid
    private Pedido pedido;

    @ManyToOne
    private Cupom cupom;

    @Deprecated
    public Compra() {
    }

    public Compra(@NotNull @Valid Cliente cliente, @NotNull @Valid Pedido pedido) {
        this.cliente = cliente;
        this.pedido = pedido;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Cupom getCupom() {
        return cupom;
    }

    public void setCupom(Cupom cupom) {
        this.cupom = cupom;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", pedido=" + pedido +
                ", cupom=" + cupom +
                '}';
    }
}
