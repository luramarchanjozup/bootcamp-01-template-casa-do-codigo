package com.github.marcoscoutozup.casadocodigo.livro;

import com.github.marcoscoutozup.casadocodigo.autor.Autor;
import com.github.marcoscoutozup.casadocodigo.categoria.Categoria;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class LivroResponse {

    private String titulo;
    private String resumo;
    private String sumario;
    private Double preco;
    private Integer numeroDePaginas;
    private String isbn;
    private LocalDate dataDePublicacao;
    private Categoria categoria;
    private Autor autor;

    public LivroResponse(Livro livro){
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numeroDePaginas = livro.getNumeroDePaginas();
        this.isbn = livro.getIsbn();
        this.dataDePublicacao = livro.getDataDePublicacao();
        this.categoria = livro.getCategoria();
        this.autor = livro.getAutor();
    }

    public static List<LivroResponse> gerarListaDeRespostaDeLivros(List<Livro> livros){
        return livros.stream()
                .map(LivroResponse::new)
                .collect(Collectors.toList());
    }
}
