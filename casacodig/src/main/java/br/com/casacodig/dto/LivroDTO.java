package br.com.casacodig.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.casacodig.model.Autor;
import br.com.casacodig.model.Categoria;
import br.com.casacodig.model.Livro;
import br.com.casacodig.validator.IdExistente;
import br.com.casacodig.validator.ValorUnico;


//Contagem de Pontos - TOTAL:3
//1 - Autor
//1 - Categoria
//1 - Livro

public class LivroDTO {

	@NotBlank @ValorUnico(classe = Livro.class,campo = "titulo")
	private String titulo;
	@NotBlank @Size(max = 500)
	private String resumo;
	@NotBlank
	private String sumario;
	@NotNull @Min(20)
	private BigDecimal preco;
	@Min(100)
	private int numeroPaginas;
	@NotBlank @ValorUnico(classe = Livro.class,campo = "isbn")
	private String isbn;
	@Future @NotNull 
	@DateTimeFormat (pattern = "yyyy-MM-dd")
	private Date dataPublicacao;
	@NotNull @IdExistente(classe = "Categoria", campo = "id")
	private Long idCategoria;
	@NotNull @IdExistente(classe = "Autor", campo = "id")
	private Long idAutor;
	
	public LivroDTO(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotBlank String sumario, @NotNull @Min(20) BigDecimal preco, 
	@Min(100) int numeroPaginas,@NotBlank String isbn, @Future @NotNull Date dataPublicacao, @NotNull Long idCategoria, @NotNull Long idAutor) {
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
	
	
	public Livro toModel(EntityManager manager) {
		@NotNull Autor autor = manager.find(Autor.class, this.idAutor);
		@NotNull Categoria categoria = manager.find(Categoria.class, this.idCategoria);
		return new Livro(this.titulo, this.resumo, this.sumario, this.preco, this.numeroPaginas, this.isbn,
				this.dataPublicacao, autor, categoria);
	}

}
