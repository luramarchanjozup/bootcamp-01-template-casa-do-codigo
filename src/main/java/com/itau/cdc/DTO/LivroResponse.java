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

	@JsonProperty("id_categoria")
	@NotNull
	private Long idCategoria;

	@JsonProperty("id_autor")
	@NotNull
	private Long idAutor;

	public LivroResponse(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario,
			@NotNull @Min(20) BigDecimal preco, @NotNull Integer numeroPaginas, @NotBlank String isbn,
			@NotNull Date dataPublicacao, @NotNull Long idCategoria, @NotNull Long idAutor) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.idCategoria = idCategoria;
		this.idAutor = idAutor;
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

	public Long getIdCategoria() {
		return idCategoria;
	}

	public Long getIdAutor() {
		return idAutor;
	}
	
}
