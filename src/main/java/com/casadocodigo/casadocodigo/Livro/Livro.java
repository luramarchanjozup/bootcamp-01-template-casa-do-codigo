package com.casadocodigo.casadocodigo.Livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.casadocodigo.casadocodigo.Autor.Autor;
import com.casadocodigo.casadocodigo.Categoria.Categoria;
import com.sun.istack.NotNull;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private @NotBlank String titulo;
	private @NotBlank @Size(max = 500) String resumo;
	private @NotBlank String sumario;
	private @NotNull @Min(20) BigDecimal preco;
	private @NotNull @Min(100) int paginas;
	private @NotBlank String isbn;

	private @NotNull LocalDate dataPublicacao;
	@ManyToOne
	private @NotNull @Valid Autor autor;
	@ManyToOne
	private @NotNull @Valid Categoria categoria;

	public Long getId() {
		return id;
	}

	public BigDecimal getPreco() {
		return preco;
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

	public int getPaginas() {
		return paginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public Autor getAutor() {
		return autor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	@Deprecated
	public Livro() {

	}

	public Livro(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotBlank String sumario,
			@NotNull @Min(20) BigDecimal preco, @NotBlank @Min(100) int paginas, @NotBlank String isbn,
			@NotNull LocalDate dataPublicacao, @NotNull Autor autor, @NotNull Categoria categoria) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.paginas = paginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.autor = autor;
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Livro [id = " + id + ", titulo =" + titulo + ", resumo = " + resumo + ", sumario = " + sumario
				+ ", preco = " + preco + ", paginas  " + paginas + ", isbn = " + isbn + ", dataPublicacao = "
				+ dataPublicacao + ", autor = " + autor + ", categoria = " + categoria + "]";
	}

}
