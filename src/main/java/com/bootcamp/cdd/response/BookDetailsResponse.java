package com.bootcamp.cdd.response;

public class BookDetailsResponse {
    private String titulo;
    private String resumo;
    private String sumario;
    private int quantPaginas;
    private double preco;
    private String isnb;
    private String nomeAutor;
    private String descAutor;

    public BookDetailsResponse(String titulo, String resumo, String sumario, int quantPaginas, double preco, String isnb, String nomeAutor, String descAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.quantPaginas = quantPaginas;
        this.preco = preco;
        this.isnb = isnb;
        this.nomeAutor = nomeAutor;
        this.descAutor = descAutor;
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

    public int getQuantPaginas() {
        return quantPaginas;
    }

    public double getPreco() {
        return preco;
    }

    public String getIsnb() {
        return isnb;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public String getDescAutor() {
        return descAutor;
    }
}
