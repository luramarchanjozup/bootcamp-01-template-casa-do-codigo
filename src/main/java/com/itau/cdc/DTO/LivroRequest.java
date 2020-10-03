package com.itau.cdc.DTO;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.itau.cdc.Repository.AutorJpaRepository;
import com.itau.cdc.Repository.CategoriaJpaRepository;
import com.itau.cdc.model.Autor;
import com.itau.cdc.model.Categoria;
import com.itau.cdc.model.Livro2;

public class LivroRequest {

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

	public LivroRequest(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario,
			@NotBlank @Min(20) BigDecimal preco, @NotBlank Integer numeroPaginas, @NotBlank String isbn,
			@NotNull Date dataPublicacao, @NotNull @NotBlank Long categoria, @NotNull @NotBlank Long autor) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.idCategoria = categoria;
		this.idAutor = autor;
	}

	public LivroRequest() {
		super();
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
	
	public @Valid Livro2 toModel(LivroRequest request, CategoriaJpaRepository categoriaJpaRepository, AutorJpaRepository autorJpaRepository, EntityManager manager) {
	
		Categoria categoria  = manager.find(Categoria.class, idCategoria);
		Autor autor = manager.find(Autor.class,  idAutor);
		
		Assert.state(categoria!=null || autor!=null, "Categoria e autor não existem");
		Assert.state(categoria!=null, "Categoria não existe");
		Assert.state(autor!=null, "Autor não existe");
		
		return new Livro2(titulo, resumo, sumario, preco, numeroPaginas, isbn, dataPublicacao, categoria, autor);
		
	}
	
}
