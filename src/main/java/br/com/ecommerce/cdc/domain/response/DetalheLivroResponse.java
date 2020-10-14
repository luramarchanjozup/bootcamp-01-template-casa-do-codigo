package br.com.ecommerce.cdc.domain.response;

import br.com.ecommerce.cdc.domain.model.Autor;
import br.com.ecommerce.cdc.domain.model.Livro;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class DetalheLivroResponse {

    @NotNull
    private Long id;
    @NotBlank
    private String titulo;
    @NotBlank
    private String conteudo;
    @NotBlank
    private String sumario;
    @NotNull
    private BigDecimal preco;
    @NotNull
    private Integer numPagina;
    @NotBlank
    private String isbn;
    @NotNull
    private Autor autor;

    public DetalheLivroResponse() {
    }

    public DetalheLivroResponse(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.conteudo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numPagina = livro.getNumPagina();
        this.isbn = livro.getIsbn();
        this.autor = livro.getAutor();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getNumPagina() {
        return numPagina;
    }

    public String getIsbn() {
        return isbn;
    }

    public Autor getAutor() {
        return autor;
    }
}
