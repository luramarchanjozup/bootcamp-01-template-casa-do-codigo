package br.com.itau.casadocodigo.casadocodigoAPI.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class NovaCompraItensCarrinhoDTO {

	private int id;
	private int idLivro;
	private int quantidade;
	// 1
	@JsonIgnore
	private NovaCompraDTO novaCompra;

	public NovaCompraItensCarrinhoDTO(int idLivro, int quantidade, NovaCompraDTO compra) {
		this.idLivro = idLivro;
		this.quantidade = quantidade;
		this.novaCompra = compra;
	}

	@Deprecated
	public NovaCompraItensCarrinhoDTO() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public NovaCompraDTO getNovaCompra() {
		return novaCompra;
	}

	public void setNovaCompra(NovaCompraDTO novaCompra) {
		this.novaCompra = novaCompra;
	}

}
