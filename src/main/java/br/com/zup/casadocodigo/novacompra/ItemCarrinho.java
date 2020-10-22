package br.com.zup.casadocodigo.novacompra;

import java.math.BigDecimal;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.zup.casadocodigo.livro.Livro;

@Embeddable
public class ItemCarrinho {

	@NotNull
	@ManyToOne
	private Livro livro;

	@Positive
	private int quantidade;

	@Positive
	private BigDecimal precoMomento;

	@Deprecated
	public ItemCarrinho() {

	}

	public ItemCarrinho(@NotNull Livro livro, @Positive int quantidade) {

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

	public int getQuantidade() {
		return quantidade;
	}

	public BigDecimal getPrecoMomento() {
		return precoMomento;
	}

}
