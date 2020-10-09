package br.com.treino.casadocodigo.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.Objects;

public class ItemPedido {

    @NotNull
    private Livro livro;
    @NotNull @Min(1) @Positive
    private int quantidade;
    @NotNull @Min(20)
    private BigDecimal precoLivro;

    @Deprecated
    public ItemPedido(){}

    public ItemPedido(@NotNull Livro livro, @NotNull @Min(1) @Positive int quantidade) {
        this.livro = livro;
        this.quantidade = quantidade;
        this.precoLivro = livro.getPreco();
    }

    public Livro getLivro() {
        return livro;
    }

    //public BigDecimal getPrecoLivro() { return precoLivro; }

    public int getQuantidade() {
        return quantidade;
    }

    public BigDecimal valorTotal(){
        return this.precoLivro.multiply(new BigDecimal(this.quantidade));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemPedido)) return false;
        ItemPedido that = (ItemPedido) o;
        return getLivro().equals(that.getLivro());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLivro());
    }

}
