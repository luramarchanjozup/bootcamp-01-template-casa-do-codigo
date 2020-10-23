package com.guiferrini.CasaCodigo.model;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class ItemPedidoDTO {

	@NotNull
	@IdUnico(domainClass=NovoLivro.class, fieldName="id", message="ERRO. O id do livro é obrigatório.")
	private String idNovoLivro;
	
	@NotNull
	@Positive(message = "Por favor, informar a quantidade de produtos produto. O quantidade não pode ser zero.")
	private int quantidade;
	
	@Deprecated
	public ItemPedidoDTO() {
	}

	public ItemPedidoDTO(@NotNull String idNovoLivro,
			@Positive(message = "Por favor, informar a quantidade de produtos produto. O quantidade não pode ser zero.") int quantidade) {
		super();
		this.idNovoLivro = idNovoLivro;
		this.quantidade = quantidade;
	}

	public String getIdNovoLivro() {
		return idNovoLivro;
	}

	public void setIdNovoLivro(String idNovoLivro) {
		this.idNovoLivro = idNovoLivro;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public ItemPedido toModel(EntityManager entityManager) {
		
		@NotNull NovoLivro idLivro = entityManager.find(NovoLivro.class, this.idNovoLivro); //this.idNovoLivro
		
		return new ItemPedido(idLivro, this.quantidade);
	}
	
	
	
}
