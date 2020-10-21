package com.guiferrini.CasaCodigo.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.util.Assert;

@Entity
@Table(name="pedido")
public class Pedido {
	
	@Id
	@Column(name="id", nullable=false)
	@GeneratedValue(generator = "UUID", strategy = GenerationType.SEQUENCE)
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;
	
	//@OneToMany(cascade = {CascadeType.ALL})
	@ElementCollection // classe q recebe, com //@Embeddable
	@Size(min=1, message = "O pedido tem que ter no minimo 1 item")
	@NotNull
	@Valid
	private List<ItemPedido> itens;
	
	@NotNull(message = "O total não pode ser zero")
	@Positive(message = "O total tem que ser maior que zero")
	private BigDecimal total;

	@Deprecated
	public Pedido() {
	}

	public Pedido(@NotNull @Positive BigDecimal total, 
				@NotNull @Valid @Size(min = 1) List<ItemPedido> itens) {
		super();
		
		Assert.isTrue(!itens.isEmpty(), "O pedido tem que ter no minimo 1 item");
		
		this.total = total;
		this.itens = itens;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
	@Override
	public String toString() {
		return "Pedido [itens= " + itens + "]";
	}
	
	public boolean check(@NotNull(message = "O total não pode ser zero") @Positive(message = "O total tem que ser maior que zero") BigDecimal total) {
		
		List<ItemPedido> listaItemPedido = new ArrayList<>();
		double soma = 0.0;
		
		for(ItemPedido item : itens) { 
			Double itemPedido2 = item.getNovoLivro().getPreco();
			soma += itemPedido2;
		}
		BigDecimal b1 = new BigDecimal(Double.toString(soma));

		return b1 == total;
	} 
}
