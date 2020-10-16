package com.cdcAPI.api.model.Response;

import com.cdcAPI.model.Livro;

import java.math.BigDecimal;
import java.time.LocalDate;

//Complexidade = 1?
//Livro

public class LivroResponse {

    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private int n_paginas;
    private String isbn;
    private LocalDate dataPublicacao;
    private AutorResponse autor;
    private CategoriaResponse categoria;

    public LivroResponse(Livro livro) {

        titulo = livro.getTitulo();
        resumo = livro.getResumo();
        sumario = livro.getSumario();
        preco = livro.getPreco();
        n_paginas = livro.getN_paginas();
        isbn = livro.getIsbn();
        dataPublicacao = livro.getDataPublicacao();
        autor = new AutorResponse(livro.getAutor());
        categoria = new CategoriaResponse(livro.getCategoria());
    }

    //get e set

    public CategoriaResponse getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaResponse categoria) {
        this.categoria = categoria;
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

    public int getN_paginas() {
        return n_paginas;
    }

    public void setN_paginas(int n_paginas) {
        this.n_paginas = n_paginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public AutorResponse getAutor() {
        return autor;
    }

    public void setAutor(AutorResponse autor) {
        this.autor = autor;
    }
}
