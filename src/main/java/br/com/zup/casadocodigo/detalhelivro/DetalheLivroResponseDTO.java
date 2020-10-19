package br.com.zup.casadocodigo.detalhelivro;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

import br.com.zup.casadocodigo.livro.Livro;

public class DetalheLivroResponseDTO {

	private Long idLivro;

	private String titulo;

	private String resumo;

	private String sumario;

	private BigDecimal preco;

	private int numeroPaginas;

	private String isbn;

	private String dataPublicacao;

	private DetalheAutorResponseDTO autor;

	private String categoria;

	public DetalheLivroResponseDTO(Livro dadosLivro) {
		this.idLivro = dadosLivro.getIdLivro();
		this.titulo = dadosLivro.getTitulo();
		this.resumo = dadosLivro.getResumo();
		this.sumario = dadosLivro.getSumario();
		this.preco = dadosLivro.getPreco();
		this.numeroPaginas = dadosLivro.getNumeroPaginas();
		this.isbn = dadosLivro.getIsbn();
		this.dataPublicacao = dadosLivro.getDataPublicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		this.autor = new DetalheAutorResponseDTO(dadosLivro.getAutor());
		this.categoria = dadosLivro.getCategoria().getNome();
	}

	public Long getIdLivro() {
		return idLivro;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getDataPublicacao() {
		return dataPublicacao;
	}

	public DetalheAutorResponseDTO getAutor() {
		return autor;
	}

	public String getCategoria() {
		return categoria;
	}
}
