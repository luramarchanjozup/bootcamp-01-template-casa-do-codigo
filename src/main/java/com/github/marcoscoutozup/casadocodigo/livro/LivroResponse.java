package com.github.marcoscoutozup.casadocodigo.livro;

import com.github.marcoscoutozup.casadocodigo.autor.AutorResponse;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class LivroResponse {

    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer numeroDePaginas;
    private String isbn;
    private LocalDate dataDePublicacao;
    private AutorResponse autor;

    public LivroResponse(Livro livro){
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numeroDePaginas = livro.getNumeroDePaginas();
        this.isbn = livro.getIsbn();
        this.dataDePublicacao = livro.getDataDePublicacao();
        this.autor = new AutorResponse(livro.getAutor());
    }

    public static List<LivroResponse> gerarListaDeRespostaDeLivros(List<Livro> livros){
        return livros.stream()
                .map(LivroResponse::new)
                .collect(Collectors.toList());
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

    public Integer getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataDePublicacao() {
        return dataDePublicacao;
    }

    public AutorResponse getAutor() {
        return autor;
    }
}
