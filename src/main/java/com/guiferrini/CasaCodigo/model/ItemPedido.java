package com.guiferrini.CasaCodigo.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.annotations.GenericGenerator;

//@Entity
@Embeddable
public class ItemPedido {

	//@Id
	//@Column(name="id", nullable=false)
	//@GeneratedValue(generator = "UUID", strategy = GenerationType.SEQUENCE)
    //@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	//private String id;
	
	@ManyToOne
	@NotNull
	private NovoLivro novoLivro;
	
	@Positive(message = "Por favor, informar a quantidade de produtos. A quantidade não pode ser zero.")
	private int quantidade;
	
	@Positive
	private BigDecimal preco;
	
	@Deprecated
	public ItemPedido() {
	}

	public ItemPedido(@NotNull NovoLivro novoLivro, @Positive int quantidade) {
		super();
		this.novoLivro = novoLivro;
		this.quantidade = quantidade;
		this.preco = novoLivro.getPreco();
	}

	public NovoLivro getNovoLivro() {
		return novoLivro;
	}

	public int getQuantidade() {
		return quantidade;
	}
	
	public BigDecimal total() {
		return preco.multiply(new BigDecimal(quantidade));
	}
	
	@Override
	public String toString() {
		return "ItemPedido [livro= " + 
				novoLivro + 
				", quantidade= " + 
				quantidade + 
				"]";
	}
}
