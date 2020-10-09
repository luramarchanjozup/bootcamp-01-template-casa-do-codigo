package br.com.itau.casadocodigo.casadocodigoAPI.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.itau.casadocodigo.casadocodigoAPI.controller.form.ItemForm;

public class CarrinhoCompras {

	@NotBlank
	@Min(value = 1)
	private BigDecimal total;
	//1
	@Size(min = 1)
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
