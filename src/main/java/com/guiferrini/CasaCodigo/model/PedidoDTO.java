package com.guiferrini.CasaCodigo.model;

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

import org.springframework.util.Assert;

public class PedidoDTO {

	@NotNull(message = "O total não pode ser zero")
	@Positive(message = "O total tem que ser maior que zero")
	private BigDecimal total;
	
	@NotNull
	@Valid
	@Size(min=1)
	private List<ItemPedidoDTO> itensPedido = new ArrayList();
	
	@Deprecated
	public PedidoDTO() {
	}

	public PedidoDTO(@NotNull @Positive BigDecimal total, @Valid @Size(min = 1) List<ItemPedidoDTO> itensPedido) {
		super();
		this.total = total;
		this.itensPedido = itensPedido; 
	}
	
	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public List<ItemPedidoDTO> getItensPedido() {
		return itensPedido;
	}

	public void setItensPedido(List<ItemPedidoDTO> itensPedido) {
		this.itensPedido = itensPedido;
	}

	public Pedido toModel(EntityManager entityManager) {
		
		List<ItemPedido> listaItemPedido = new ArrayList<>();
		
		for(ItemPedidoDTO item : itensPedido) { //P cada 'ItemPedidoDTO' -> 'item', contido em 'this.itensPedido' faça...
			ItemPedido itemPedido = item.toModel(entityManager); //retorna IdLivro e qdade
			listaItemPedido.add(itemPedido); //adiciona na lista
		}

		//Pedido pedido = new Pedido(total, listaItemPedido);
		//System.out.println(pedido.check(total));
		//Assert.state(pedido.check(total) == this.getTotal(),"ERRO, valores diferentes"); //da erro...
		//Assert.isTrue(pedido.check(total),"ERRO, valores diferentes"); //da erro... IllegalArgumentException - quebra a aplicação...	 	
		
		return new Pedido(total, listaItemPedido); 
	}	
}
	