package io.github.evertoncnsouza.domain.entity;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.Objects;


@Embeddable //Declara que esta classe será integrada a outras entidades;
public class ItemPedido {

    @ManyToOne
    @NotNull
    private Livro livro;

    @Positive
    private int quantidade;

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

    public BigDecimal total(){
        return precoMomento.multiply(new BigDecimal(quantidade));
    }

    public Livro getLivro() {
        return livro;
    }

    public BigDecimal getPrecoMomento() {
        return precoMomento;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return "ItemPedido{" +
                "livro=" + livro +
                ", quantidade=" + quantidade +
                ", precoMomento=" + precoMomento +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemPedido)) return false;
        ItemPedido that = (ItemPedido) o;
        return Objects.equals(getLivro(), that.getLivro());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLivro());
    }
}
