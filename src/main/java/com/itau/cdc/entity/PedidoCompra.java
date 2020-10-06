package com.itau.cdc.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
public class PedidoCompra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private NovaCompra compra;
	
	@ElementCollection
	@Size(min = 1)
	private  Set<ItemPedido> itens = new HashSet<>();

	public PedidoCompra(@NotNull @Valid NovaCompra compra, @Size(min = 1) Set<ItemPedido> itensCalculados) {
		super();
		this.compra = compra;
		this.itens.addAll(itensCalculados);
	}

	public PedidoCompra() {
		super();
	}

	public boolean totalIgual(@Positive BigDecimal total) {
		BigDecimal totalPedido = itens.stream().map(ItemPedido::total).reduce(BigDecimal.ZERO,
				(atual, proximo) -> atual.add(proximo));		
		
		return totalPedido.doubleValue() == total.doubleValue();
	}
	
}
