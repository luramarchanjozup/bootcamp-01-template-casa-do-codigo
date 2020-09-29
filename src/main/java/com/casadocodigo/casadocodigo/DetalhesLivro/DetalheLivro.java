package com.casadocodigo.casadocodigo.DetalhesLivro;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

import com.casadocodigo.casadocodigo.Livro.Livro;

public class DetalheLivro {

	private DetalheAutor autor;
	private String titulo;
	private String isbn;
	private int paginas;
	private BigDecimal preco;
	private String resumo;
	private String sumario;
	private String dataPublicacao;

	public DetalheAutor getAutor() {
		return autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public int getPaginas() {
		return paginas;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public String getDataPublicacao() {
		return dataPublicacao;
	}

	public DetalheLivro(Livro livro) {
		titulo = livro.getTitulo();
		preco = livro.getPreco();
		resumo = livro.getResumo();
		sumario = livro.getSumario();
		autor = new DetalheAutor(livro.getAutor());
		paginas = livro.getPaginas();
		dataPublicacao = livro.getDataPublicacao().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		isbn = livro.getIsbn();
	}
	
}
