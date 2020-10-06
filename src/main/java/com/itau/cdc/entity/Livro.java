package com.itau.cdc.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	private Long id;
	
	@NotBlank
	@Column(name="titulo", nullable = false)
	private String titulo;

	@NotBlank
	@Size(max = 500)
	@Column(name="resumo", nullable = false)
	private String resumo;

	@Column(name="sumario", nullable = false)
	private String sumario;

	@NotNull
	@Min(20)
	@Column(name="preco", nullable = false)
	private BigDecimal preco;

	@NotNull
	@Column(name="numero_paginas", nullable = false)
	private Integer numeroPaginas;

	@NotBlank
	@Column(name="isbn", nullable = false)
	private String isbn;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	
	@Column(name="data_publicacao", nullable = false)
	private Date dataPublicacao;
	
	@ManyToOne(targetEntity = Categoria.class)
	private Categoria categoria;
	
	@ManyToOne(targetEntity = Autor.class)
	private Autor autor;

	public Livro() {
		super();
	}
	
	public Livro(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario,
			@NotBlank @Min(20) BigDecimal preco, @NotBlank Integer numeroPaginas, @NotBlank String isbn,
			@NotNull Date dataPublicacao, @NotNull Categoria categoria, @NotNull Autor autor) {
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

	public Long getId() {
		return id;
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

	public Categoria getCategoria() {
		return categoria;
	}

	public Autor getAutor() {
		return autor;
	}
	
}
