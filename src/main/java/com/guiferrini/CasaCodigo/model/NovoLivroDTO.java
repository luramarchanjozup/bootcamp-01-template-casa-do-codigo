package com.guiferrini.CasaCodigo.model;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class NovoLivroDTO {
	
	@NotBlank(message="Título obrigatório")
	@ValorUnico(domainClass=NovoLivro.class, fieldName="titulo", message="Título já existente")
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
	@ValorUnico(domainClass=NovoLivro.class, fieldName="identificador", message="Identificador já existente")
	private String identificador;
		
	@NotNull(message="Data obrigatória e futura")
	@Future
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate date;
	
	private Autor autor;
	
	//@NotNull(message = "Autor obrigatório")
	@IdUnico(domainClass = Autor.class, fieldName = "id", message = "O ID do Autor é obrigatório e tem ser válido")
	private String idAutor;
	
	//@NotNull(message = "Categoria obrigatória")
	@IdUnico(domainClass = Categoria.class, fieldName = "id", message = "O ID da Categoria é obrigatório e tem ser válido")
	private String idCategoria;
	
	public NovoLivroDTO() { 
	} 
 
	public NovoLivroDTO(@NotBlank String titulo,
			@NotBlank @Size(max = 500) String resumo, String sumario,
			@NotNull @Min(20) Double preco,
			@NotNull @Min(100) Integer paginas,
			@NotBlank String identificador, @Future
			@NotNull LocalDate date, @NotNull String idCategoria,
			@NotNull String idAutor) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.paginas = paginas;
		this.identificador = identificador;
		this.date = date;
		this.idAutor = idAutor;
		this.idCategoria = idCategoria;
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

	public String getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(String idAutor) {
		this.idAutor = idAutor;
	}

	public String getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(String idCategoria) {
		this.idCategoria = idCategoria;
	}

	public NovoLivro toModel(EntityManager entityManager) {
		
		@NotNull Autor autor = entityManager.find(Autor.class, idAutor);
		@NotNull Categoria categoria = entityManager.find(Categoria.class, idCategoria);
		
		//alternativa isTrue, n usar if (2ptos)
		Assert.state(autor != null, "Favor verificar nome do Autor, este nome não está cadastrado.");
		Assert.state(categoria != null, "Favor verificar nome da Categoria, este nome não está cadastrado");
		
		return new NovoLivro(titulo, resumo, sumario, preco, paginas, identificador, date, autor, categoria);
		//return obj;
	} 
}
