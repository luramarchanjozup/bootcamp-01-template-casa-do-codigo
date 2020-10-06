package com.itau.cdc.DTO;

import javax.persistence.EntityManager;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.itau.cdc.entity.ItemPedido;
import com.itau.cdc.entity.Livro;
import com.sun.istack.NotNull;

public class ItemCompraRequest {

	@NotNull
	@JsonProperty("idLivro")
	private Long idLivro;
	
	@Positive
	@JsonProperty("quantidade")
	private int quantidade;

	public int getQuantidade() {
		return quantidade;
	}

	public Long getIdLivro() {
		return idLivro;
	}

	public ItemCompraRequest() {
		super();
	}

	public ItemPedido toModel(EntityManager manager) {
		@NotNull 
		Livro livro = manager.find(Livro.class, idLivro);
		
		if(livro == null) {
			throw new IllegalArgumentException("id_livro = " + idLivro + " não cadastrado.");
		}
		
		
		
		return new ItemPedido(livro, livro.getPreco(), quantidade);
	}
	
}
