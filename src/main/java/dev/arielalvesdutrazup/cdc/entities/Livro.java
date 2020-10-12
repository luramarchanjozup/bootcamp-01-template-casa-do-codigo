package dev.arielalvesdutrazup.cdc.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "{titulo.notemtpy}")
    private String titulo;
    @Column(columnDefinition = "TEXT")
    @Size(max = 500, message = "{resumo.max}")
    @NotBlank(message = "{resumo.notemtpy}")
    private String resumo;
    private String sumario;
    @Min(value = 20, message = "{preco.min}")
    @NotNull(message = "{preco.notnull}")
    private BigDecimal preco;
    @Min(value = 100, message = "{numeroDePaginas.min}")
    @NotNull(message = "{numeroDePaginas.notnull}")
    private Integer numeroDePaginas;
    @NotNull(message = "{isbn.notnull}")
    private String isbn;
    @NotNull(message = "{dataPublicacao.notnull}")
    private LocalDate dataPublicacao;
    private OffsetDateTime cadastradoEm = OffsetDateTime.now();
    @NotNull(message = "{categoria.notnull}")
    @ManyToOne
    private Categoria categoria;
    @NotNull(message = "{autor.notnull}")
    @ManyToOne
    private Autor autor;

    @JsonIgnore
    @OneToMany(mappedBy = "livro", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CompraItem> itens = new HashSet<>();

    public Long getId() {
        return id;
    }

    public Livro setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitulo() {
        return titulo;
    }

    public Livro setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public String getResumo() {
        return resumo;
    }

    public Livro setResumo(String resumo) {
        this.resumo = resumo;
        return this;
    }

    public String getSumario() {
        return sumario;
    }

    public Livro setSumario(String sumario) {
        this.sumario = sumario;
        return this;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Livro setPreco(BigDecimal preco) {
        this.preco = preco;
        return this;
    }

    public Integer getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public Livro setNumeroDePaginas(Integer numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
        return this;
    }

    public String getIsbn() {
        return isbn;
    }

    public Livro setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Livro setCategoria(Categoria categoria) {
        this.categoria = categoria;
        return this;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Livro setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
        return this;
    }

    public OffsetDateTime getCadastradoEm() {
        return cadastradoEm;
    }

    public Livro setCadastradoEm(OffsetDateTime cadastradoEm) {
        this.cadastradoEm = cadastradoEm;
        return this;
    }

    public Autor getAutor() {
        return autor;
    }

    public Livro setAutor(Autor autor) {
        this.autor = autor;
        return this;
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
                ", dataPublicacao=" + dataPublicacao +
                ", cadastradoEm=" + cadastradoEm +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(id, livro.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
