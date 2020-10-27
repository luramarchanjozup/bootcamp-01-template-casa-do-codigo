package com.casadocodigo.casadocodigo.FluxoPagamento.ItemPedido;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.casadocodigo.casadocodigo.Livro.Livro;
import com.casadocodigo.casadocodigo.Validation.ConfirmarExistencia;

public class ItemPedidoDto {

	private @NotNull @ConfirmarExistencia(classe = Livro.class, campo = "id") Long idLivro;
	private @Positive int quantidade;

	public ItemPedido toModel(EntityManager manager) {
		Livro livro = manager.find(Livro.class, idLivro);
		return new ItemPedido(livro, quantidade);
	}

	public Long getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(Long idLivro) {
		this.idLivro = idLivro;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}