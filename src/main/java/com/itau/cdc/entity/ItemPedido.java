package com.itau.cdc.entity;

import java.math.BigDecimal;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Positive;

import com.sun.istack.NotNull;

@Embeddable
public class ItemPedido {
	
	@Positive
	private int quantidade;
	
	@Positive
	private BigDecimal precoMomento;
	
	@ManyToOne
	@NotNull
	private Livro livro;

	public ItemPedido(Livro livro, BigDecimal precoMomento, @Positive int quantidade) {
		super();
		this.livro=livro;
		this.precoMomento=precoMomento;
		this.quantidade=quantidade;
	}

	@Deprecated
	public ItemPedido() {
		super();
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
	
	public BigDecimal total() {
		return precoMomento.multiply(new BigDecimal(quantidade));
	}
	
}
