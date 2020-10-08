package com.itau.cdc.DTO;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LivroResponse {

	@JsonProperty("titulo")
	@NotBlank
	private String titulo;

	@JsonProperty("resumo")
	@NotBlank
	@Size(max = 500)
	private String resumo;

	@JsonProperty("sumario")
	private String sumario;

	@JsonProperty("preco")
	@NotNull
	@Min(20)
	private BigDecimal preco;

	@JsonProperty("numero_paginas")
	@NotNull
	private Integer numeroPaginas;

	@JsonProperty("isbn")
	@NotBlank
	private String isbn;

	@JsonProperty("data_publicacao")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@NotNull
	private Date dataPublicacao;

	@JsonProperty("categoria")
	@NotNull
	private CategoriaResponse categoria;

	@JsonProperty("autor")
	@NotNull
	private AutorResponse autor;

	public LivroResponse(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario,
			@NotNull @Min(20) BigDecimal preco, @NotNull Integer numeroPaginas, @NotBlank String isbn,
			@NotNull Date dataPublicacao, @NotNull CategoriaResponse categoria, @NotNull AutorResponse autor) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.categoria = categoria;
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	public CategoriaResponse getCategoria() {
		return categoria;
	}

	public AutorResponse getAutor() {
		return autor;
	}

	
}
