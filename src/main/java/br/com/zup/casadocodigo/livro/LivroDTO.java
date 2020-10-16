package br.com.zup.casadocodigo.livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zup.casadocodigo.autor.Autor;
import br.com.zup.casadocodigo.categoria.Categoria;

public class LivroDTO {

	@NotBlank
	private String titulo;
	
	@NotBlank
	@Size(max = 500)
	private String resumo;
	
	@NotBlank
	private String sumario;
	
	@NotNull
	@Min(20)
	private BigDecimal preco;
	
	@Min(100)
	private int numeroPaginas;
	
	@NotBlank
	private String isbn;
	
	@NotNull
	@Future
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate dataPublicacao;
	
	@NotNull
	private Integer idCategoria;
	
	
	@NotNull
	private Integer idAutor;
	
	
	public LivroDTO(@NotBlank String titulo,@NotBlank @Size(max = 500) String resumo, @NotBlank String sumario,
			@NotNull @Min(20) BigDecimal preco, @Min(100) int numeroPaginas, @NotBlank String isbn, @NotNull Integer idCategoria, 
			@NotNull Integer idAutor) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.idCategoria = idCategoria;
		this.idAutor = idAutor;
		
	}
	
	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public Livro geraNovoLivro(EntityManager bancoDados) {
		Autor buscaAutor = bancoDados.find(Autor.class, idAutor);
		Categoria buscaCategoria = bancoDados.find(Categoria.class, idCategoria);
		
		Livro novoLivro = new Livro(titulo, resumo, sumario, preco, numeroPaginas,
				isbn, dataPublicacao, buscaAutor, buscaCategoria);

		return novoLivro;
		
	}
	
}
