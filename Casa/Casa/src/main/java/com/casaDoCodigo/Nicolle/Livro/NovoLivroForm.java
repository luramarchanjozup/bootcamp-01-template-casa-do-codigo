package com.casaDoCodigo.Nicolle.Livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.casaDoCodigo.Nicolle.Autor.Autor;
import com.casaDoCodigo.Nicolle.Autor.AutorRepository;
import com.casaDoCodigo.Nicolle.Categoria.Categoria;
import com.casaDoCodigo.Nicolle.Categoria.CategoriaRepository;
import com.casaDoCodigo.Nicolle.Validadores.MinhaAnotacao;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.sun.istack.NotNull;

public class NovoLivroForm {
	@NotBlank
	@Size(max = 100)
	@MinhaAnotacao(dominioClasse = Livro.class, nomeCampo = "titulo")
	private String titulo;
	
	@NotBlank
	@Size(max = 500)
	private String resumo;
	
	
	@Min(20)
	private BigDecimal preco;
	
	@NotBlank
	private String sumario;
	
	@Min(100)
	private int numeroPaginas;
	
	@NotBlank
	@MinhaAnotacao(dominioClasse = Livro.class, nomeCampo = "isbn")
	private String isbn;
	
	@NotNull
    @Future
    @JsonFormat(shape = Shape.STRING,pattern = "dd/MM/yyyy")
    private LocalDate dataPublicacao;
	
	@NotNull
	private Long autorId;
	
	@NotNull
	private String categoriaNome;
	

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public String getCategoriaNome() {
		return categoriaNome;
	}

	public void setCategoriaNome(String categoriaNome) {
		this.categoriaNome = categoriaNome;
	}

	public Long getAutorId() {
		return autorId;
	}

	public void setAutorId(Long autorId) {
		this.autorId = autorId;
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

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}


	public String getSumario() {
		return sumario;
	}

	public void setSumario(String sumario) {
		this.sumario = sumario;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Livro novoLivro(AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
		Autor autor = autorRepository.findById(autorId).get();
		Categoria categoria = categoriaRepository.findByCategoria(categoriaNome).get();

		return new Livro(titulo,resumo,preco,sumario,numeroPaginas,isbn,dataPublicacao,autor,categoria);
	}

	/*public Livro novoLivro(AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
		Autor autor = autorRepository.findById(autorId).get();
		Categoria categoria = categoriaRepository.findByNome(categoriaNome).get();
		return new Livro(titulo,resumo,preco,sumario,numeroPaginas,isbn,dataPublicacao,autor,categoria);
	}*/


	
}
