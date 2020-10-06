package com.itau.cdc.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	private Set<ItemPedido> itens = new HashSet<>();

	@ManyToOne
	private Cupom2 cupom;

	public PedidoCompra(@NotNull @Valid NovaCompra compra, @Size(min = 1) Set<ItemPedido> itensCalculados,
			Cupom2 cupom) {
		super();
		this.compra = compra;
		this.itens.addAll(itensCalculados);
		this.cupom = cupom;
	}

	public PedidoCompra() {
		super();
	}

	public boolean totalIgual(@Positive BigDecimal total) {
		BigDecimal totalPedido = CalculaTotalPedidoComDesconto(
				itens.stream().map(ItemPedido::total).reduce(BigDecimal.ZERO, (atual, proximo) -> atual.add(proximo)));

		return totalPedido.doubleValue() == total.doubleValue();
	}

	private BigDecimal CalculaTotalPedidoComDesconto(BigDecimal totalPedido) {
		if (cupom == null) {
			return totalPedido;
		} else {
			return totalPedido.multiply(cupom.getPercentualTotalParaPagamento());
		}
	}

	public Long getId() {
		return id;
	}

	public NovaCompra getCompra() {
		return compra;
	}

	public Set<ItemPedido> getItens() {
		return itens;
	}

	public Cupom2 getCupom() {
		return cupom;
	}

}
