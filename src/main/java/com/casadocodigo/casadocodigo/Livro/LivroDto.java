package com.casadocodigo.casadocodigo.Livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.casadocodigo.casadocodigo.Autor.Autor;
import com.casadocodigo.casadocodigo.Categoria.Categoria;
import com.casadocodigo.casadocodigo.Validation.ConfirmarExistencia;
import com.casadocodigo.casadocodigo.Validation.ValorUnico;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

public class LivroDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private @NotBlank @ValorUnico(campo = "titulo", classe = Livro.class) String titulo;
	private @NotBlank @Size(max = 500) String resumo;
	private @NotBlank String sumario;
	private @NotNull @Positive @Min(20) BigDecimal preco;
	private @NotNull @Positive @Min(100) int paginas;
	private @NotBlank @ValorUnico(campo = "isbn", classe = Livro.class) String isbn;
	private @NotNull @Future @JsonFormat(pattern = "YYYY-MM-DD") LocalDate dataPublicacao;

	private @NotNull @Valid @ConfirmarExistencia(campo = "id", classe = Autor.class) Long idAutor;
	private @NotNull @Valid @ConfirmarExistencia(campo = "id", classe = Categoria.class) Long idCategoria;

	public LivroDto(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotBlank String sumario,
			@Min(20) BigDecimal preco, @NotNull @Min(100) int paginas, @NotBlank String isbn,
			@Future LocalDate dataPublicacao, @Valid Long idAutor, @Valid Long idCategoria) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.paginas = paginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.idAutor = idAutor;
		this.idCategoria = idCategoria;
	}

	public Livro toModel(EntityManager manager) {
		Autor autor = manager.find(Autor.class, idAutor);
		Categoria categoria = manager.find(Categoria.class, idCategoria);
		return new Livro(titulo, resumo, sumario, preco, paginas, isbn, dataPublicacao, autor, categoria);
	}

}
