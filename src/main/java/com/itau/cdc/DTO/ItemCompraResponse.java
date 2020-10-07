package com.itau.cdc.DTO;

import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

public class ItemCompraResponse {

	@NotNull
	@JsonProperty("livro")
	private LivroResponse livro;
	
	@Positive
	@JsonProperty("quantidade")
	private int quantidade;

	public ItemCompraResponse(@Positive int quantidade, LivroResponse livro) {
		super();
		this.quantidade=quantidade;
		this.livro=livro;
	}
	
	public int getQuantidade() {
		return quantidade;
	}

	public LivroResponse getLivro() {
		return livro;
	}

	public ItemCompraResponse() {
		super();
	}
	
}
