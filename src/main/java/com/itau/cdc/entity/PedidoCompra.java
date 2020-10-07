package com.itau.cdc.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

import com.itau.cdc.DTO.ItemCompraResponse;
import com.itau.cdc.DTO.PedidoCompraResponse;

@Entity
public class PedidoCompra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Positive
	private BigDecimal total;
	
	@Positive
	private BigDecimal totalSemDesconto;
	
	@OneToOne
	private NovaCompra compra;

	@ElementCollection
	@Size(min = 1)
	private Set<ItemPedido> itens = new HashSet<>();

	@ManyToOne
	private Cupom cupom;

	public PedidoCompra(@Positive BigDecimal total, @NotNull @Valid NovaCompra compra, @Size(min = 1) Set<ItemPedido> itensCalculados,
			Cupom cupom) {
		super();
		this.total=total;
		this.compra = compra;
		this.itens.addAll(itensCalculados);
		this.total=total;

		this.cupom = cupom;
		if(cupom!=null) {
			this.totalSemDesconto=calculaTotalPedido();
		}else {
			this.totalSemDesconto=total;
		}
		
	}

	public PedidoCompra() {
		super();
	}

	public BigDecimal calculaTotalPedido() {
		return itens.stream().map(ItemPedido::total).reduce(BigDecimal.ZERO, (atual, proximo) -> atual.add(proximo));
	}
	
	public boolean totalIgual(@Positive BigDecimal total) {
		BigDecimal totalPedido = CalculaTotalPedidoComDesconto(calculaTotalPedido());

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

	public Cupom getCupom() {
		return cupom;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public PedidoCompraResponse toResponse() {
		List<ItemCompraResponse> listaItens = StreamSupport.stream(itens.spliterator(), false)
				.map(item -> item.toResponse()).collect(Collectors.toList());
		if(cupom!=null) {
			return new PedidoCompraResponse(listaItens, cupom.toResponse(), total, totalSemDesconto);
		}else {
			return new PedidoCompraResponse(listaItens, total);
		}
	}

}
