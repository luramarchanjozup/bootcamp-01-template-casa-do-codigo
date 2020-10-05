package br.com.treino.casadocodigo.request;

import br.com.treino.casadocodigo.model.Livro;

import java.math.BigDecimal;

public class DetalheLivroRequest {

    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer numPaginas;
    private String isbn;
    private DetalheAutorRequest datalheAutor;

    public DetalheLivroRequest(Livro livro) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numPaginas = livro.getNumPaginas();
        this.isbn = livro.getIsbn();
        this.datalheAutor = new DetalheAutorRequest(livro.getAutor());
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

    public Integer getNumPaginas() {
        return numPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public DetalheAutorRequest getDatalheAutor() {
        return datalheAutor;
    }

}
