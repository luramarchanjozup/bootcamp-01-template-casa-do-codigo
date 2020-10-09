package br.com.itau.casadocodigo.casadocodigoAPI.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.itau.casadocodigo.casadocodigoAPI.repository.AutorRepository;

@Entity
@Table(name = "livro")
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	private String resumoLivro;
	private String sumario;
	private BigDecimal preco;
	private int nroPaginas;
	private String identificadorISBN;
	private LocalDate dataPublicacao;
	//1
	@ManyToOne(cascade = { CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumn(name = "categoria_id", referencedColumnName = "id")
	private Categoria categoria;
	//1
	@ManyToOne(cascade = { CascadeType.ALL },  fetch = FetchType.LAZY)
	@JoinColumn(name = "autor_id", referencedColumnName = "id")
	private Autor autor;

	public Livro(String titulo, String resumoLivro, String sumario, BigDecimal preco, int nroPaginas,
			String identificadorISBN, LocalDate dataPublicacao, Autor autor, Categoria categoria) {
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
	public Livro() {

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

	@Override
	public String toString() {
		return "Livro [id=" + id + ", titulo=" + titulo + ", resumoLivro=" + resumoLivro + ", sumario=" + sumario
				+ ", preco=" + preco + ", nroPaginas=" + nroPaginas + ", identificadorISBN=" + identificadorISBN
				+ ", dataPublicacao=" + dataPublicacao + ", categoria=" + categoria.getNome() + "]";
	}

}
