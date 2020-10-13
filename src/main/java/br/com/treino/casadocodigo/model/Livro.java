package br.com.treino.casadocodigo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private @NotBlank String titulo;
    private @NotBlank @Size(max = 500) String resumo;
    private String sumario;
    private @NotNull @Min(20) BigDecimal preco;
    private @NotNull @Min(100)  Integer numPaginas;
    private @NotBlank String isbn;
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private @Future @NotNull LocalDate dataPublicacao;
    private @NotNull @ManyToOne @Valid Categoria categoria; //1
    private @NotNull @ManyToOne @Valid Autor autor; //2

    @Deprecated
    public Livro(){}

    public Livro(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo,
                 String sumario, @NotNull @Min(20) BigDecimal preco,
                 @NotNull @Min(100) Integer numPaginas, @NotBlank String isbn,
                 @Future @NotNull LocalDate dataPublicacao, @NotNull Categoria categoria,
                 @NotNull Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numPaginas = numPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    /*public long getId() {
        return id;
    }*/

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

    /*public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }*/

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Autor getAutor() {
        return autor;
    }

    /*public Categoria getCategoria() {
        return categoria;
    }*/

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", resumo='" + resumo + '\'' +
                ", sumario='" + sumario + '\'' +
                ", preco=" + preco +
                ", numPaginas=" + numPaginas +
                ", isbn=" + isbn +
                ", dataPublicacao=" + dataPublicacao +
                ", categoria=" + categoria +
                ", autor=" + autor +
                '}';
    }

}
