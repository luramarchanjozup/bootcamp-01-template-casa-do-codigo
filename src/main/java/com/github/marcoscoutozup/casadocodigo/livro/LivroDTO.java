package com.github.marcoscoutozup.casadocodigo.livro;


import com.github.marcoscoutozup.casadocodigo.autor.Autor;
import com.github.marcoscoutozup.casadocodigo.categoria.Categoria;
import com.github.marcoscoutozup.casadocodigo.validator.exists.Exists;
import com.github.marcoscoutozup.casadocodigo.validator.unique.Unique;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class LivroDTO {

    @NotBlank
    @Unique(campo = "titulo", classe = Livro.class)
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    private String sumario;

    @NotNull
    @Min(20)
    private BigDecimal preco;

    @NotNull
    @Min(100)
    private Integer numeroDePaginas;

    @NotBlank
    @Unique(campo = "isbn", classe = Livro.class)
    private String isbn;

    @Future
    private LocalDate dataDePublicacao;

    @NotNull
    @Exists(classe = Categoria.class)
    private UUID categoria;

    @NotNull
    @Exists(classe = Autor.class)
    private UUID autor;

    public Livro toModel(EntityManager entityManager){
        Autor autor = entityManager.find(Autor.class, this.autor);
        Categoria categoria = entityManager.find(Categoria.class, this.categoria);
        return new Livro(titulo, resumo, sumario, preco, numeroDePaginas, isbn, dataDePublicacao, categoria, autor);
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

    public Integer getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public void setNumeroDePaginas(Integer numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getDataDePublicacao() {
        return dataDePublicacao;
    }

    public void setDataDePublicacao(LocalDate dataDePublicacao) {
        this.dataDePublicacao = dataDePublicacao;
    }

    public UUID getCategoria() {
        return categoria;
    }

    public void setCategoria(UUID categoria) {
        this.categoria = categoria;
    }

    public UUID getAutor() {
        return autor;
    }

    public void setAutor(UUID autor) {
        this.autor = autor;
    }
}
