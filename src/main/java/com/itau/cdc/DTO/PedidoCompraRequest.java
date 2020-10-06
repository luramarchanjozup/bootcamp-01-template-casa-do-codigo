package com.itau.cdc.DTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.itau.cdc.entity.ItemPedido;
import com.itau.cdc.entity.NovaCompra;
import com.itau.cdc.entity.PedidoCompra;
import com.sun.istack.NotNull;

public class PedidoCompraRequest {

	@Positive
	@NotNull
	@JsonProperty("total")
	private BigDecimal total;
	
	@Valid
	@Size(min = 1)
	private List<ItemCompraRequest> itens = new ArrayList<>();

	public PedidoCompraRequest() {
		super();
	}

	public BigDecimal getTotal() {
		return total;
	}

	public List<ItemCompraRequest> getItens() {
		return itens;
	}

	public Function<NovaCompra, PedidoCompra> toModel(EntityManager manager) {

		Set<ItemPedido> itensCalculados = itens.stream().map(item -> item.toModel(manager)).collect(Collectors.toSet());
		
		return (compra) -> {
			PedidoCompra pedido = new @Valid PedidoCompra(compra,itensCalculados);
			
			if(!pedido.totalIgual(total)) {
				throw new IllegalArgumentException("Valor total enviado no pedido não corresponde ao valor total real dos produtos.");
			}
			
			return pedido;
		};
	}
	
}
