package com.casaDoCodigo.Nicolle.Livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.casaDoCodigo.Nicolle.Autor.Autor;
import com.casaDoCodigo.Nicolle.Categoria.Categoria;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.sun.istack.NotNull;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private @NotBlank @Size(max = 100) String titulo;
	private @NotBlank @Size(max = 500) String resumo;
	private @NotNull @Min(20) BigDecimal preco;
	private @NotBlank String sumario;
	private @Min(100) int numeroPaginas;
	private @NotBlank String isbn;
	private @NotNull @Future @JsonFormat(shape = Shape.STRING,pattern = "dd/MM/yyyy") LocalDate dataPublicacao;
	private @NotNull @ManyToOne Autor autor;
	private @NotNull @ManyToOne Categoria categoria;
	
	
	@Deprecated
	public Livro() {}

	public Livro(@NotBlank @Size(max = 100) String titulo, @NotBlank @Size(max = 500) String resumo,
			@Min(20) BigDecimal preco, @NotBlank String sumario, @Min(100) int numeroPaginas,
			@NotBlank String isbn, @NotNull @Future @JsonFormat(shape = Shape.STRING,pattern = "dd/MM/yyyy") LocalDate dataPublicacao, @NotNull Autor autor, @NotNull Categoria categoria) 
	
	{
				this.titulo = titulo;
				this.resumo = resumo;
				this.preco = preco;
				this.sumario = sumario;
				this.numeroPaginas = numeroPaginas;
				this.isbn = isbn;
				this.dataPublicacao = dataPublicacao;
				this.autor = autor;
				this.categoria = categoria;
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

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public void setSumario(String sumario) {
		this.sumario = sumario;
	}

	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	
	

}
