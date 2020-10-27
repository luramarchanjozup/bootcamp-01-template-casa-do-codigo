package com.casadocodigo.casadocodigo.FluxoPagamento.Pedido;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.casadocodigo.casadocodigo.FluxoPagamento.Compra.Compra;
import com.casadocodigo.casadocodigo.FluxoPagamento.ItemPedido.ItemPedido;
import com.casadocodigo.casadocodigo.FluxoPagamento.ItemPedido.ItemPedidoDto;

public class PedidoDto {

	private @Positive @NotNull BigDecimal total;
	private @Size(min = 1) @Valid List<ItemPedidoDto> itens = new ArrayList<>();

	public PedidoDto(@Positive @NotNull BigDecimal total, @Size(min = 1) @Valid List<ItemPedidoDto> itens) {
		this.total = total;
		this.itens = itens;
	}

	public Function<Compra, Pedido> toModel(EntityManager manager) {
		Set<ItemPedido> itensPedido = itens.stream().map(item -> item.toModel(manager))
				.collect(Collectors.toSet());
		return (compra) -> {
			Pedido pedido = new Pedido(compra, itensPedido);
			return pedido;
		};
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public List<ItemPedidoDto> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedidoDto> itens) {
		this.itens = itens;
	}
}