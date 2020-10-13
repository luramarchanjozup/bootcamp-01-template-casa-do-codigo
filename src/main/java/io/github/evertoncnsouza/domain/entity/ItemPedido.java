package io.github.evertoncnsouza.domain.entity;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;


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

    @Override //Explicado passo a passo na JavaClass Livro;
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((livro ==null) ? 0 :livro.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ItemPedido other = (ItemPedido) obj;
        if (livro == null) {
            if (other.livro != null)
                return false;
        } else if (!livro.equals(other.livro))
            return false;
        return true;
    }

}

