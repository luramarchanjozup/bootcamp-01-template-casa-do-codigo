package com.itau.cdc.DTO;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.itau.cdc.entity.Livro;

public class DetalheSiteLivroResponse {

	private DetalheSiteAutorResponse autor;
	@JsonProperty("titulo")
	private String titulo;
	
	@JsonProperty("isbn")
	private String isbn;
	
	@JsonProperty("numero_paginas")
	private int numeroPaginas;
	
	@JsonProperty("preco")
	private BigDecimal preco;
	
	@JsonProperty("resumo")
	private String resumo;
	
	@JsonProperty("sumario")
	private String sumario;
	
	@JsonProperty("data_publicacao")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date dataPublicacao;
	
	public DetalheSiteLivroResponse(Livro livro) {
		super();
		this.autor = new DetalheSiteAutorResponse(livro.getAutor());
		this.titulo = livro.getTitulo();
		this.isbn = livro.getIsbn();
		this.numeroPaginas = livro.getNumeroPaginas();
		this.preco = livro.getPreco();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.dataPublicacao = livro.getDataPublicacao();
	}

	public DetalheSiteAutorResponse getAutor() {
		return autor;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public int getNumeroPaginas() {
		return numeroPaginas;
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
	
	public Date getDataPublicacao() {
		return dataPublicacao;
	}
	
	
	
}
