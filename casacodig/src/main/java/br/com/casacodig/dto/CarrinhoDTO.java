package br.com.casacodig.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.casacodig.model.Carrinho;
import br.com.casacodig.model.ItemCarrinho;

public class CarrinhoDTO {

	@NotNull @Positive
	private BigDecimal total; 
	@Valid @NotNull 
	private List<ItemCarrinhoDTO> itensCarrinho = new ArrayList<>();
	
	
	public CarrinhoDTO(@NotNull @Positive BigDecimal total, @Valid List<ItemCarrinhoDTO> itensCarrinho) {
		super();
		this.total = total;
		this.itensCarrinho = itensCarrinho;
	}


	public Carrinho toModel(EntityManager manager) {
		List<ItemCarrinho> listaItemCarrinhos = new ArrayList<>();
		for (ItemCarrinhoDTO item: this.itensCarrinho) {
			ItemCarrinho itemcarrinho = item.toModel(manager);
			listaItemCarrinhos.add(itemcarrinho);
		}
		return new Carrinho(this.total, listaItemCarrinhos);
	}
	
	public BigDecimal getTotal() {
		return total;
	}


	public List<ItemCarrinhoDTO> getItensCarrinho() {
		return itensCarrinho;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}


	public void setItensCarrinho(List<ItemCarrinhoDTO> itensCarrinho) {
		this.itensCarrinho = itensCarrinho;
	}


	@Override
	public String toString() {
		return "CarrinhoDTO [total=" + total + ", itensCarrinho=" + itensCarrinho + "]";
	}
	
	
	
}
