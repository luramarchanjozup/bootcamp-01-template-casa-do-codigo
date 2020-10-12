package com.guiferrini.CasaCodigo.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="novolivro")
public class NovoLivro {

	@Id
	@Column(name="id", nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	@NotBlank(message="Título obrigatório")
	private String titulo;
	
	@NotBlank(message="Resumo obrigatório")
	@Size(max=500)
	private String resumo;

	private String sumario;

	@NotNull(message="Preço obrigatório")
	@Min(20)
	private Double preco;
	
	@NotNull(message="Número de paginas obrigatório")
	@Min(100)
	private Integer paginas;
	
	@NotBlank(message="Identificador obirgatório")
	private String identificador;
	
	@NotNull(message="Data obrigatória e futura")
	@Future
	private LocalDate date;
	
	@Deprecated
	public NovoLivro() {
	}

	public NovoLivro(@NotBlank(message = "Título obrigatório") String titulo,
			@NotBlank(message = "Resumo obrigatório") @Size(max = 500) String resumo, String sumario,
			@NotNull(message = "Preço obrigatório") @Min(20) Double preco,
			@NotNull(message = "Número de paginas obrigatório") @Min(100) Integer paginas,
			@NotBlank(message = "Identificador obirgatório") String identificador, @NotNull
			@Future LocalDate date) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.paginas = paginas;
		this.identificador = identificador;
		this.date = date;
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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
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
}
