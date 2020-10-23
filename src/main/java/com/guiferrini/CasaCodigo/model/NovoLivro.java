package com.guiferrini.CasaCodigo.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="novolivro")
public class NovoLivro {

	@Id
	@Column(name="id", nullable=false)
	@GeneratedValue(generator = "UUID", strategy = GenerationType.SEQUENCE)
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;
	
	@NotBlank(message="Título obrigatório")
	private String titulo;
	
	@NotBlank(message="Resumo obrigatório") 
	@Size(max=500)
	private String resumo;

	private String sumario;

	@NotNull(message="Preço obrigatório")
	@Min(20)
	private BigDecimal preco;
	
	@NotNull(message="Número de paginas obrigatório")
	@Min(100)
	private Integer paginas;
	
	@NotBlank(message="Identificador obirgatório")
	private String identificador;
	
	@NotNull(message="Data obrigatória e futura")
	@Future
	private LocalDate date;
	
	@ManyToOne
	@NotNull
	private Autor autor;
	
	@ManyToOne
	@NotNull
	private Categoria categoria;  
	
	@Deprecated
	public NovoLivro() {
	}

	public NovoLivro(@NotBlank String titulo,
			@NotBlank @Size(max = 500) String resumo, String sumario,
			@NotNull @Min(20) BigDecimal preco,
			@NotNull @Min(100) Integer paginas,
			@NotBlank String identificador, @NotNull
			@Future LocalDate date, Autor autor, Categoria categoria) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.paginas = paginas;
		this.identificador = identificador;
		this.date = date;
		this.autor = autor;
		this.categoria = categoria;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public void setSumario(String sumario) {
		this.sumario = sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Integer getPaginas() {
		return paginas;
	}

	public void setPaginas(Integer paginas) {
		this.paginas = paginas;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public String toString() {
		return "Livro [id=" + id + ", titulo=" + titulo + ", resumo=" + resumo
				+ ", sumario=" + sumario + ", preco=" + preco
				+ ", numeroPaginas=" + paginas + ", isbn=" + identificador
				+ ", dataPublicacao=" + date + ", autor=" + autor
				+ ", categoria=" + categoria + "]";
	}
}
