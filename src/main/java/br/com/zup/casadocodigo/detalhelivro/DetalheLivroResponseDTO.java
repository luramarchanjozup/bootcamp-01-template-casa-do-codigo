package br.com.zup.casadocodigo.detalhelivro;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

import br.com.zup.casadocodigo.livro.Livro;

//4
public class DetalheLivroResponseDTO {

	private Integer idLivro;

	private String titulo;

	private String resumo;

	private String sumario;

	private BigDecimal preco;

	private int numeroPaginas;

	private String isbn;

	private String dataPublicacao;
//1
	private DetalheAutorResponseDTO autor;

	private String categoria;

//1
	public DetalheLivroResponseDTO(Livro dadosLivro) {
		this.idLivro = dadosLivro.getIdLivro();
		this.titulo = dadosLivro.getTitulo();
		this.resumo = dadosLivro.getResumo();
		this.sumario = dadosLivro.getSumario();
		this.preco = dadosLivro.getPreco();
		this.numeroPaginas = dadosLivro.getNumeroPaginas();
		this.isbn = dadosLivro.getIsbn();
//1		
		this.dataPublicacao = dadosLivro.getDataPublicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//1
		this.autor = new DetalheAutorResponseDTO(dadosLivro.getAutor());
		this.categoria = dadosLivro.getCategoria().getNome();
	}

	public Integer getIdLivro() {
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
