package com.github.marcoscoutozup.casadocodigo.livro;

import com.github.marcoscoutozup.casadocodigo.autor.Autor;
import com.github.marcoscoutozup.casadocodigo.categoria.Categoria;

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

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public Double getPreco() {
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

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", resumo='" + resumo + '\'' +
                ", sumario='" + sumario + '\'' +
                ", preco=" + preco +
                ", numeroDePaginas=" + numeroDePaginas +
                ", isbn='" + isbn + '\'' +
                ", dataDePublicacao=" + dataDePublicacao +
                ", categoria=" + categoria.getNome() +
                ", autor=" + autor.getNome() +
                '}';
    }
}
