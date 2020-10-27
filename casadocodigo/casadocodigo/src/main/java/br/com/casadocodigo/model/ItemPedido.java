package br.com.casadocodigo.model;

import javax.persistence.Embedded;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Embedded
public class ItemPedido {

    @ManyToOne
    private @NotNull Livro livro;
    private @Positive int quantidade;
    @Positive
    private BigDecimal precoMomento;

    @Deprecated
    public ItemPedido() {

    }

    public ItemPedido(@NotNull Livro livro, @Positive int quantidade) {
        this.livro = livro;
        this.quantidade = quantidade;
        this.precoMomento = livro.getPreco();
    }

    @Override
    public String toString() {
        return "ItemPedido [livro=" + livro + ", quantidade=" + quantidade
                + ", precoMomento=" + precoMomento + "]";
    }

    public BigDecimal total() {
        return precoMomento.multiply(new BigDecimal(quantidade));
    }
}
