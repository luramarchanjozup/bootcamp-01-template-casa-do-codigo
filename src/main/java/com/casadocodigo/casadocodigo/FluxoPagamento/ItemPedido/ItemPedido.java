package com.casadocodigo.casadocodigo.FluxoPagamento.ItemPedido;

import java.math.BigDecimal;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.casadocodigo.casadocodigo.Livro.Livro;

@Embeddable
public class ItemPedido {
	private @ManyToOne @NotNull Livro livro;
	private @Positive @NotNull int quantidade;
	private @Positive BigDecimal preco;

	@Deprecated
	public ItemPedido() {
	}

	public ItemPedido(@NotNull Livro livro, @Positive @NotNull int quantidade) {
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