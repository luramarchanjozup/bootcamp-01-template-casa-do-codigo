package br.com.casadocodigo.model;


import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    @NotBlank
    private String sumario;

    @NotBlank
    @Min(20)
    private BigDecimal preco;

    @NotBlank
    @Min(100)
    private int numeroDePaginas;

    @NotBlank
    private String isbnLivro;

    @NotNull
    @Future
    private LocalDate dataDePublicacao;

    @NotNull
    @Valid
    @ManyToOne
    private Autor autor;

    @NotNull
    @Valid
    @ManyToOne
    private Categoria categoria;

    public Livro(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo,
                 @NotBlank String sumario, @NotBlank @Min(20) BigDecimal preco,
                 @NotBlank @Min(100) int numeroDePaginas, @NotBlank String isbnLivro,
                 @NotNull @Future LocalDate dataDePublicacao, @NotNull @Valid Autor autor,
                 @NotNull @Valid Categoria categoria) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroDePaginas = numeroDePaginas;
        this.isbnLivro = isbnLivro;
        this.dataDePublicacao = dataDePublicacao;
        this.autor = autor;
        this.categoria = categoria;
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

    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public String getIsbnLivro() {
        return isbnLivro;
    }

    public LocalDate getDataDePublicacao() {
        return dataDePublicacao;
    }

    public Autor getAutor() {
        return autor;
    }

    public Categoria getCategoria() {
        return categoria;
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
                ", isbnLivro='" + isbnLivro + '\'' +
                ", dataDePublicacao=" + dataDePublicacao +
                ", autor=" + autor +
                ", categoria=" + categoria +
                '}';
    }
}
