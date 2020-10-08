package com.itau.cdc.DTO;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

public class PedidoCompraResponse {

	@Positive
	@NotNull
	@JsonProperty("total")
	private BigDecimal total;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Positive
	@JsonProperty("total_sem_desconto")
	private BigDecimal totalSemDesconto;

	@Valid
	@Size(min = 1)
	private List<ItemCompraResponse> itens;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("cupom")
	private CupomResponse cupom;

	public PedidoCompraResponse(List<ItemCompraResponse> listaItens, CupomResponse cupom, BigDecimal total, BigDecimal totalSemDesconto) {
		super();
		this.itens=listaItens;
		this.cupom=cupom;
		this.total=total;
		this.totalSemDesconto=totalSemDesconto;
	}

	public PedidoCompraResponse(List<ItemCompraResponse> listaItens, @Positive BigDecimal total) {
		super();
		this.itens=listaItens;
		this.cupom=null;
		this.total=total;
		this.totalSemDesconto=null;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public List<ItemCompraResponse> getItens() {
		return itens;
	}

	public CupomResponse getCupom() {
		return cupom;
	}

	public BigDecimal getTotalSemDesconto() {
		return totalSemDesconto;
	}


}
