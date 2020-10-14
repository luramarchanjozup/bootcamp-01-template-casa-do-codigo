package br.com.casacodig.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Carrinho {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id") 
	private Long id;
	@NotNull 
	private BigDecimal total; 
	private BigDecimal totalComDesconto;
	@OneToMany(cascade = {CascadeType.ALL})@NotNull 
	private List<ItemCarrinho> items;
	

	@Deprecated
	public Carrinho(){
		
	}

	public Carrinho(@NotNull BigDecimal total, @NotNull List<ItemCarrinho> items) {
		this.total = total;
		this.items = items;
	}
	
	
	public void atualizaValor(BigDecimal desconto) {
		BigDecimal valorDesconto = this.total.multiply(desconto);
		valorDesconto = valorDesconto.setScale(2);
		this.totalComDesconto = this.total.subtract(valorDesconto);
	}
	

	public BigDecimal getTotal() {
		return total;
	}

	public List<ItemCarrinho> getItems() {
		return items;
	}
	
	
	
	public BigDecimal getTotalComDesconto() {
		return totalComDesconto;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Carrinho [id=" + id + ", total=" + total + ", totalComDesconto=" + totalComDesconto + ", items=" + items
				+ "]";
	}

	

	

}
