package br.com.zup.cdc.nicolle.response;

import java.math.BigDecimal;

import br.com.zup.cdc.nicolle.model.Autor;
import br.com.zup.cdc.nicolle.model.Categoria;
import br.com.zup.cdc.nicolle.model.Livro;

public class DetalhesDoLivroResponse {
	
	private Long id;
	private String titulo;
	private String resumo;
	private BigDecimal preco;
	private String sumario;
	private int numeroPaginas;
	private String isbn;
	private Autor autor;
	private Categoria categoria;
	
	public DetalhesDoLivroResponse(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.preco = livro.getPreco();
		this.sumario = livro.getSumario();
		this.numeroPaginas = livro.getNumeroPaginas();
		this.isbn = livro.getIsbn();
		this.autor = livro.getAutor();
		this.categoria = livro.getCategoria();
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public String getSumario() {
		return sumario;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public Autor getAutor() {
		return autor;
	}

	public Categoria getCategoria() {
		return categoria;
	}
	
	
	
	
	


}
