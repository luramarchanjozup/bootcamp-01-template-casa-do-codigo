package br.com.itau.casadocodigo.casadocodigoAPI.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.itau.casadocodigo.casadocodigoAPI.repository.LivroRepository;

public class NovaCompraDetalhesResponse {

	// 1
	private NovaCompra novaCompra;
	@JsonIgnore
	private String cupom = "Sem cupons";
	// 1
	private List<NovaCompraItensCarrinho> novaCompraItensCarrinho;

	public NovaCompraDetalhesResponse(NovaCompra novaCompra, List<NovaCompraItensCarrinho> novaCompraItensCarrinho) {
		this.novaCompra = novaCompra;
		this.novaCompraItensCarrinho = novaCompraItensCarrinho;
	}

	public NovaCompra getNovaCompra() {
		return novaCompra;
	}

	public void setNovaCompra(NovaCompra novaCompra) {
		this.novaCompra = novaCompra;
	}

	public List<NovaCompraItensCarrinho> getNovaCompraItensCarrinho() {
		return novaCompraItensCarrinho;
	}

	public void setNovaCompraItensCarrinho(List<NovaCompraItensCarrinho> novaCompraItensCarrinho) {
		this.novaCompraItensCarrinho = novaCompraItensCarrinho;
	}

	public String getCupom() {
		return cupom;
	}

	public void setCupom(String cupom) {
		this.cupom = cupom;
	}

}
