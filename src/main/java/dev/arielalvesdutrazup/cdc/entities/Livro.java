package dev.arielalvesdutrazup.cdc.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer numeroDePaginas;
    private String isbn;
    private LocalDate dataPublicacao;
    private OffsetDateTime cadastradoEm = OffsetDateTime.now();
    @ManyToOne
    private Categoria categoria;
    @ManyToOne
    private Autor autor;

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
}
