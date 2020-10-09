package br.com.casacodig.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author gabri
 *
 */
@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long livro_id;
	@NotBlank
	private String titulo;
	@NotBlank @Size(max = 500) 
	private String resumo;
	@NotBlank
	private String sumario;
	@NotNull @Min(20) 
	private BigDecimal preco;
	@Min(100) 
	private int numeroPaginas;
	@NotBlank
	private String isbn;
	@NotNull @Future
	private Date dataPublicacao;
	@ManyToOne @NotNull @Valid 
	private Autor autor;
	@ManyToOne @NotNull @Valid 
	private Categoria categoria;
	
	@Deprecated
	public Livro() {

	}

	public Livro(@NotBlank String titulo,@NotBlank @Size(max = 500) String resumo, @NotBlank String sumario, @NotNull @Min(20) BigDecimal preco, 
			@Min(100) int numeroPaginas, @NotBlank String isbn, @Future @NotNull Date dataPublicacao, @NotNull @Valid Autor autor, @NotNull @Valid Categoria categoria) {
				this.titulo = titulo;
				this.resumo = resumo;
				this.sumario = sumario;
				this.preco = preco;
				this.numeroPaginas = numeroPaginas;
				this.isbn = isbn;
				this.dataPublicacao = dataPublicacao;
				this.autor = autor;
				this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Livro [livro_id=" + livro_id + ", titulo=" + titulo + ", resumo=" + resumo + ", sumario=" + sumario
				+ ", preco=" + preco + ", numeroPaginas=" + numeroPaginas + ", isbn=" + isbn + ", dataPublicacao="
				+ dataPublicacao + ", autor=" + autor + ", categoria=" + categoria + "]";
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

	public int getNumeroPaginas() {
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
