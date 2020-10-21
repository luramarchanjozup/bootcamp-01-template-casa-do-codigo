package br.com.zup.casadocodigo.novacompra;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class CarrinhoCompraDTO {

	@Positive
	@NotNull
	private BigDecimal total;
	@Size(min = 1)
	@Valid
	private List<ItemCarrinhoDTO> itens = new ArrayList<>();

	public CarrinhoCompraDTO(@Positive @NotNull BigDecimal total, @Size(min = 1) @Valid List<ItemCarrinhoDTO> itens) {
		this.total = total;
		this.itens = itens;
	}

	public List<ItemCarrinhoDTO> getItens() {
		return itens;
	}
}
