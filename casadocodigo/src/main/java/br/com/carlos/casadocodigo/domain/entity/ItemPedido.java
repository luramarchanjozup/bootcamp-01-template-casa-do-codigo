package br.com.carlos.casadocodigo.domain.entity;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Embeddable
public class ItemPedido {
    @ManyToOne @NotNull
    private Livro livro;

    @Positive
    private  int quantidade;

    @Positive
    private BigDecimal precoMomento;

    @Deprecated
    public ItemPedido() {}

    public ItemPedido(Livro livro, int quantidade) {
        this.livro = livro;
        this.quantidade = quantidade;
        this.precoMomento = livro.getPreco();
    }

    public BigDecimal total() {
        return precoMomento.multiply(new BigDecimal(quantidade));
    }


    public Livro getLivro() {
        return livro;
    }
    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoMomento() {
        return precoMomento;
    }

    public void setPrecoMomento(BigDecimal precoMomento) {
        this.precoMomento = precoMomento;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((livro == null) ? 0 : livro.hashCode());
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
            return other.livro == null;
        } else return livro.equals(other.livro);
    }
}
