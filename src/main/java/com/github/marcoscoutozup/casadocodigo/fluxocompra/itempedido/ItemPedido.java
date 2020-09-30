package com.github.marcoscoutozup.casadocodigo.fluxocompra.itempedido;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.UUID;

@Embeddable
public class ItemPedido {

    @NotNull
    private UUID idLivro;

    @NotNull
    @Positive
    private Integer quantidade;

    @Deprecated
    public ItemPedido() {
    }

    public ItemPedido(@NotNull UUID idLivro, @NotNull @Positive Integer quantidade) {
        this.idLivro = idLivro;
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "ItemPedido{" +
                "idLivro=" + idLivro +
                ", quantidade=" + quantidade +
                '}';
    }

}
