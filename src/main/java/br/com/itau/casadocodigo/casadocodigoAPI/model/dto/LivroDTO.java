package br.com.itau.casadocodigo.casadocodigoAPI.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import br.com.itau.casadocodigo.casadocodigoAPI.model.Autor;
import br.com.itau.casadocodigo.casadocodigoAPI.model.Categoria;

public class LivroDTO {

	private Integer id;
	private String titulo;
	private String resumoLivro;
	private String sumario;
	private BigDecimal preco;
	private int nroPaginas;
	private String identificadorISBN;
	private LocalDate dataPublicacao;
	// 1
	private String categoria;
	// 1
	private String autor;

	public LivroDTO(Integer id, String titulo, String resumoLivro, String sumario, BigDecimal preco, int nroPaginas,
			String identificadorISBN, LocalDate dataPublicacao, String autor, String categoria) {
		this.id = id;
		this.titulo = titulo;
		this.resumoLivro = resumoLivro;
		this.sumario = sumario;
		this.preco = preco;
		this.nroPaginas = nroPaginas;
		this.identificadorISBN = identificadorISBN;
		this.dataPublicacao = dataPublicacao;
		this.categoria = categoria;
		this.autor = autor;
	}

	@Deprecated
	public LivroDTO() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "LivroDTO [id=" + id + ", titulo=" + titulo + ", resumoLivro=" + resumoLivro + ", sumario=" + sumario
				+ ", preco=" + preco + ", nroPaginas=" + nroPaginas + ", identificadorISBN=" + identificadorISBN
				+ ", dataPublicacao=" + dataPublicacao + ", categoria=" + categoria + ", autor=" + autor + "]";
	}

}
