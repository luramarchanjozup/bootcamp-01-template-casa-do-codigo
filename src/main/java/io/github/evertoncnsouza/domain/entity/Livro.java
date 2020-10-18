package io.github.evertoncnsouza.domain.entity;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

//2 PCI's
@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{campo.titulo.obrigatorio}")
    private String titulo;

    @NotBlank(message ="{campo.resumo.obrigatorio}")
    @Size(max = 500)
    private String resumo;

    @NotBlank
    private String sumario;

    @NotNull(message= "{campo.preco.obrigatorio}")
    @Min(20)
    private BigDecimal preco;

    @Min(100)
    @NotNull(message = "{numero.paginas.obrigatorio}")
    private int numeroPaginas;

    @NotBlank(message = "{informe.codigo.isbn}")
    private String isbn;

    @NotNull
    @Future
    private LocalDate dataPublicacao;

    @NotNull
    @ManyToOne
    @Valid
    private Autor autor;
    //PCI 1;

    @NotNull
    @ManyToOne
    @Valid
    private Categoria categoria;
    //PCI 2;

    @Deprecated
    public Livro() {
    }

    public Livro(@NotBlank String titulo, @NotBlank @Size(max = 500)
            String resumo, @NotBlank String sumario, @NotNull @Min(20) BigDecimal preco,
                 @Min(100) int numeroPaginas,
                 @NotBlank String isbn, @NotNull @Future LocalDate dataPublicacao, @NotNull @Valid Autor autor,
                 @NotNull @Valid Categoria categoria) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.autor = autor;
        this.categoria = categoria;
    }
//Todos os gets foram feitos para a classe DetalheSiteLivroResponse;
    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public LocalDate getDataPublicacao() {
        return this.dataPublicacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Livro)) return false;
        Livro livro = (Livro) o;
        return Objects.equals(getIsbn(), livro.getIsbn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIsbn());
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", resumo='" + resumo + '\'' +
                ", sumario='" + sumario + '\'' +
                ", preco=" + preco +
                ", numeroPaginas=" + numeroPaginas +
                ", isbn='" + isbn + '\'' +
                ", dataPublicacao=" + dataPublicacao +
                ", autor=" + autor +
                ", categoria=" + categoria +
                '}';
    }
}

