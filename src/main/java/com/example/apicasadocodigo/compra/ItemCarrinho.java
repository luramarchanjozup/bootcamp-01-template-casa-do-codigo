package com.example.apicasadocodigo.compra;

import com.example.apicasadocodigo.novolivro.Livro;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Embeddable
public class ItemCarrinho {
    private @ManyToOne @NotNull Livro livro;
    private @Positive @NotNull int quantidade;
    private @Positive BigDecimal preco;

    @Deprecated
    public ItemCarrinho() {
    }

    public ItemCarrinho(@NotNull Livro livro, @Positive @NotNull int quantidade) {
        this.livro = livro;
        this.quantidade = quantidade;
        this.preco = livro.getPreco();
    }

    public BigDecimal total() {
        return preco.multiply(new BigDecimal(quantidade));
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

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}