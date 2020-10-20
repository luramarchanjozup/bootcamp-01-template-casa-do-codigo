package com.guiferrini.CasaCodigo.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

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
	@Size(min=1)
	@NotNull
	private List<ItemPedido> itens;
	
	@NotNull
	private BigDecimal total;

	@Deprecated
	public Pedido() {
	}

	public Pedido(@NotNull BigDecimal total, @NotNull @Size(min = 1) List<ItemPedido> itens) {
		super();
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
}
