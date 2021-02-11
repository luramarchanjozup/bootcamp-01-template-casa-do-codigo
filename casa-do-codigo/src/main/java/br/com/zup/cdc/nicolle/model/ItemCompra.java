package br.com.zup.cdc.nicolle.model;

import java.math.BigDecimal;

public class ItemCompra {
	
	private Livro livro;
	private int quantidade;
	private BigDecimal preço;
	private String titulo;
	
	@Deprecated
	public ItemCompra() {}
	
	
	public ItemCompra(Livro livro, int quantidade, BigDecimal preço, String titulo) {
		this.livro = livro;
		this.quantidade = quantidade;
		this.preço = preço;
		this.titulo = titulo;
	}


	@Override
	public String toString() {
		return "ItemCompra [livro=" + livro + ", quantidade=" + quantidade + ", preço=" + preço + ", titulo=" + titulo
				+ "]";
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
	public BigDecimal getPreço() {
		return preço;
	}
	public void setPreço(BigDecimal preço) {
		this.preço = preço;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
	

}
