package com.github.marcoscoutozup.casadocodigo.livro;

import com.github.marcoscoutozup.casadocodigo.cadastroautor.Autor;
import com.github.marcoscoutozup.casadocodigo.cadastrocategoria.Categoria;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Livro {

    @Id
    @GeneratedValue(generator = "uuid4")
    private UUID id;

    @NotBlank
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    @Lob
    private String sumario;

    @NotNull
    @Min(20)
    private Double preco;

    @NotNull
    @Min(100)
    private Integer numeroDePaginas;

    @NotBlank
    private String isbn;

    @Future
    private LocalDate dataDePublicacao;

    @NotNull
    @ManyToOne
    private Categoria categoria;

    @NotNull
    @ManyToOne
    private Autor autor;

    @Deprecated
    public Livro() {
    }

    public Livro(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario, @NotBlank Double preco, @NotBlank @Min(100) Integer numeroDePaginas, @NotBlank String isbn, LocalDate dataDePublicacao) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroDePaginas = numeroDePaginas;
        this.isbn = isbn;
        this.dataDePublicacao = dataDePublicacao;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
