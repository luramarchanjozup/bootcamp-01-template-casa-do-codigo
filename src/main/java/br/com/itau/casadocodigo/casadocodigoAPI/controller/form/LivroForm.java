package br.com.itau.casadocodigo.casadocodigoAPI.controller.form;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.itau.casadocodigo.casadocodigoAPI.config.validacao.anotacoes.UniqueValue;
import br.com.itau.casadocodigo.casadocodigoAPI.config.validacao.anotacoes.VerificaExistenciaTuplaRelacao;
import br.com.itau.casadocodigo.casadocodigoAPI.model.Autor;
import br.com.itau.casadocodigo.casadocodigoAPI.model.Categoria;
import br.com.itau.casadocodigo.casadocodigoAPI.model.Livro;
import br.com.itau.casadocodigo.casadocodigoAPI.repository.AutorRepository;

public class LivroForm {

	@NotBlank
	// 1
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo")
	private String titulo;
	@NotBlank
	@Size(max = 500)
	private String resumoLivro;
	private String sumario;
	@DecimalMin(value = "20.0")
	private BigDecimal preco;
	@Min(value = 100)
	private int nroPaginas;
	@NotBlank
	private String identificadorISBN;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Future
	private LocalDate dataPublicacao;
	@NotBlank
	// 1
	@VerificaExistenciaTuplaRelacao(domainClass = Categoria.class, fieldName = "nome")
	private String categoria;
	@NotBlank
	@VerificaExistenciaTuplaRelacao(domainClass = Autor.class, fieldName = "nome")
	private String autor;

	// 1 //1
	public Livro converter(Optional<Autor> autor, Optional<Categoria> categoria) {

		return new Livro(this.titulo, this.resumoLivro, this.sumario, this.preco, this.nroPaginas,
				this.identificadorISBN, this.dataPublicacao, autor != null ? autor.get() : null,
				categoria != null ? categoria.get() : null);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getResumoLivro() {
		return resumoLivro;
	}

	public void setResumoLivro(String resumoLivro) {
		this.resumoLivro = resumoLivro;
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

	public int getNroPaginas() {
		return nroPaginas;
	}

	public void setNroPaginas(int nroPaginas) {
		this.nroPaginas = nroPaginas;
	}

	public String getIdentificadorISBN() {
		return identificadorISBN;
	}

	public void setIdentificadorISBN(String identificadorISBN) {
		this.identificadorISBN = identificadorISBN;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

}
