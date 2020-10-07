package com.itau.cdc.DTO;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.itau.cdc.configuration.exception.ApiErroException;
import com.itau.cdc.entity.Autor;
import com.itau.cdc.entity.Categoria;
import com.itau.cdc.entity.Livro;

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
	
	public @Valid Livro toModel(EntityManager manager) {
	
		Categoria categoria  = manager.find(Categoria.class, idCategoria);
		Autor autor = manager.find(Autor.class,  idAutor);
		
		if((categoria==null && autor==null)) {
			throw new ApiErroException(HttpStatus.UNPROCESSABLE_ENTITY, "Categoria e autor não cadastrados.");
		}else if(categoria==null) {
			throw new ApiErroException(HttpStatus.UNPROCESSABLE_ENTITY, "Categoria não cadastrada.");
		}else if(autor==null) {
			throw new ApiErroException(HttpStatus.UNPROCESSABLE_ENTITY, "Autor(a) não cadastrado(a).");
		}
		
		return new Livro(titulo, resumo, sumario, preco, numeroPaginas, isbn, dataPublicacao, categoria, autor);
		
	}
	
}
