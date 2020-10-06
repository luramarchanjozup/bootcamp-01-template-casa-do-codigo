package br.com.zup.treinocasadocodigo.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Contagem de carga intrínseca da classe: 3
 */

public class LivroRetornoDetalhes {

    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private int nPaginas;
    private String isbn;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;
    private CategoriaRetorno categoria;
    private AutorRetorno autor;

    //1
    public LivroRetornoDetalhes(Livro livro) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.nPaginas = livro.getnPaginas();
        this.isbn = livro.getIsbn();
        this.dataPublicacao = livro.getDataPublicacao();
        //1
        this.categoria = new CategoriaRetorno(livro.getCategoria());
        //1
        this.autor = new AutorRetorno(livro.getAutor());
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

    public int getnPaginas() {
        return nPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public CategoriaRetorno getCategoria() {
        return categoria;
    }

    public AutorRetorno getAutor() {
        return autor;
    }
}
