package br.com.itau.casadocodigo.exibelivros.model;

import br.com.itau.casadocodigo.cadastrocategoria.model.Categoria;
import br.com.itau.casadocodigo.novoautor.model.Autor;
import br.com.itau.casadocodigo.novolivro.model.Livro;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ExibeLivroResponse {

    private final Long id;
    private final String titulo;
    private final String resumo;
    private final String sumario;
    private final BigDecimal preco;
    private final int numeroPaginas;
    private final String isbn;
    private final LocalDate dataLancamento;
    private final Autor autor;
    private final Categoria categoria;

    public Long getId() {
        return id;
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

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public Autor getAutor() {
        return autor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public ExibeLivroResponse(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numeroPaginas = livro.getNumeroPaginas();
        this.isbn = livro.getIsbn();
        this.dataLancamento = livro.getDataLancamento();
        this.autor = livro.getAutor();
        this.categoria = livro.getCategoria();
    }
}
