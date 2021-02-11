package com.casaDoCodigo.Nicolle.Compra;

import java.math.BigDecimal;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.casaDoCodigo.Nicolle.Livro.Livro;

@Embeddable
public class ItemCompra {
	
	private @ManyToOne @NotNull @Valid Livro livro;
	private @Positive @NotNull int quantidade;
	private @Positive @NotNull BigDecimal preco;
	private @Positive @NotNull BigDecimal total;
	private @NotBlank String titulo;
	private @NotBlank Long id;
	
	@Deprecated
	public ItemCompra() {}

	public ItemCompra(@NotNull @Valid Livro livro, @Positive @NotNull int quantidade, @Positive @NotNull BigDecimal preco, @Positive @NotNull BigDecimal total, @NotBlank String titulo, Long id) {
		this.livro = livro;
		this.quantidade = quantidade;
		this.preco = preco;
		this.total = total;
		this.titulo = titulo;
		this.id = id;
	}

	@Override
	public String toString() {
		return "ItemCompra [livro=" + livro + ", quantidade=" + quantidade + ", preco=" + preco + ", total=" + total
				+ ", titulo=" + titulo + ", id=" + id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemCompra other = (ItemCompra) obj;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
	
	
}
