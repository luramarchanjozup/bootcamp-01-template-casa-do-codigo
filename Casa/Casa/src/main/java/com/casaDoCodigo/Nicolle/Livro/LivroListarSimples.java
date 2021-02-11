package com.casaDoCodigo.Nicolle.Livro;

public class LivroListarSimples {
	
	private String titulo;
	private String nomeAutor;
	
	public LivroListarSimples(Livro livro) {
		this.titulo = livro.getTitulo();
		this.nomeAutor = livro.getAutor().getNome();
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}
	
	
	
	
	
}
