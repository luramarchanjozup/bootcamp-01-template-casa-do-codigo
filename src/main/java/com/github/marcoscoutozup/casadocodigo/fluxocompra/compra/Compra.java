package com.github.marcoscoutozup.casadocodigo.fluxocompra.compra;

import com.github.marcoscoutozup.casadocodigo.fluxocompra.cliente.Cliente;
import com.github.marcoscoutozup.casadocodigo.fluxocompra.pedido.Pedido;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

    @Override
    public String toString() {
        return "Compra{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", pedido=" + pedido +
                '}';
    }
}
