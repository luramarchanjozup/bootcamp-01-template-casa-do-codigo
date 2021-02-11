package com.casaDoCodigo.Nicolle.Carrinho;

import java.math.BigDecimal;

import javax.validation.constraints.Positive;

import org.springframework.util.Assert;

import com.casaDoCodigo.Nicolle.Compra.ItemCompra;
import com.casaDoCodigo.Nicolle.Livro.Livro;
import com.casaDoCodigo.Nicolle.Livro.LivroRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LivroCarrinho {

	private String titulo;
	private BigDecimal preco;
	private int quantidade = 1;
	private Long id;
	
	
	@Deprecated
	public LivroCarrinho() {}

	public LivroCarrinho(Livro livro) {
		this.titulo = livro.getTitulo();
		this.preco = livro.getPreco();
		this.id = livro.getId();
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
	public BigDecimal getTotal() {
		return preco.multiply(new BigDecimal(quantidade));
	}

	@Override
	public String toString() {
		return "LivroCarrinho [titulo=" + titulo + ", preco=" + preco + "]";
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
		LivroCarrinho other = (LivroCarrinho) obj;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
	
	public void incrementar() {	
		this.setQuantidade(this.getQuantidade() + 1);
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public void atualizarQuantidade(@Positive int novaQuantidade) {
		Assert.isTrue(novaQuantidade > 0,"A quantidade deve ser maior que zero");
		this.quantidade = novaQuantidade;
		
	}

	public ItemCompra novoItemCompra(LivroRepository livroRepository) {
		
		return new ItemCompra(livroRepository.findById(this.id).get(), this.quantidade, this.preco, this.getTotal(), this.getTitulo(), this.getId());
	}
	
	
}
