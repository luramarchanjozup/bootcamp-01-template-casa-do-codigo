package br.com.itau.casadocodigo.casadocodigoAPI.model.dto;

import java.math.BigDecimal;
import java.util.List;

import br.com.itau.casadocodigo.casadocodigoAPI.controller.form.ItemForm;

public class CarrinhoComprasDTO {

	private BigDecimal total;
	private List<ItemForm> itens;

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public List<ItemForm> getItens() {
		return itens;
	}

	public void setItens(List<ItemForm> itens) {
		this.itens = itens;
	}

}
