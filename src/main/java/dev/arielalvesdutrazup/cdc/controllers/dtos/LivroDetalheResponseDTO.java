package dev.arielalvesdutrazup.cdc.controllers.dtos;

import dev.arielalvesdutrazup.cdc.entities.Livro;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;

public class LivroDetalheResponseDTO {

    private Long id;
    private String titulo;
    private String resumo;
    private String sumario;
    private String isbn;
    private BigDecimal preco;
    private Integer numeroDePaginas;
    private LocalDate dataPublicacao;
    private OffsetDateTime cadastradoEm;
    private AutorResponseDTO autor;
    private CategoriaResponseDTO categoria;

    public LivroDetalheResponseDTO() {}

    public LivroDetalheResponseDTO(Livro livro) {
        setId(livro.getId());
        setTitulo(livro.getTitulo());
        setResumo(livro.getResumo());
        setSumario(livro.getSumario());
        setIsbn(livro.getIsbn());
        setPreco(livro.getPreco());
        setDataPublicacao(livro.getDataPublicacao());
        setNumeroDePaginas(livro.getNumeroDePaginas());
        setCadastradoEm(livro.getCadastradoEm());
        setAutor(new AutorResponseDTO(livro.getAutor()));
        setCategoria(new CategoriaResponseDTO(livro.getCategoria()));
    }

    public Long getId() {
        return id;
    }

    public LivroDetalheResponseDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitulo() {
        return titulo;
    }

    public LivroDetalheResponseDTO setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public String getResumo() {
        return resumo;
    }

    public LivroDetalheResponseDTO setResumo(String resumo) {
        this.resumo = resumo;
        return this;
    }

    public String getSumario() {
        return sumario;
    }

    public LivroDetalheResponseDTO setSumario(String sumario) {
        this.sumario = sumario;
        return this;
    }

    public String getIsbn() {
        return isbn;
    }

    public LivroDetalheResponseDTO setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public LivroDetalheResponseDTO setPreco(BigDecimal preco) {
        this.preco = preco;
        return this;
    }

    public Integer getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public LivroDetalheResponseDTO setNumeroDePaginas(Integer numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
        return this;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public LivroDetalheResponseDTO setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
        return this;
    }

    public OffsetDateTime getCadastradoEm() {
        return cadastradoEm;
    }

    public LivroDetalheResponseDTO setCadastradoEm(OffsetDateTime cadastradoEm) {
        this.cadastradoEm = cadastradoEm;
        return this;
    }

    public AutorResponseDTO getAutor() {
        return autor;
    }

    public LivroDetalheResponseDTO setAutor(AutorResponseDTO autor) {
        this.autor = autor;
        return this;
    }

    public CategoriaResponseDTO getCategoria() {
        return categoria;
    }

    public LivroDetalheResponseDTO setCategoria(CategoriaResponseDTO categoria) {
        this.categoria = categoria;
        return this;
    }

    @Override
    public String toString() {
        return "LivroDetalheResponseDTO{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", resumo='" + resumo + '\'' +
                ", sumario='" + sumario + '\'' +
                ", isbn='" + isbn + '\'' +
                ", preco=" + preco +
                ", numeroDePaginas=" + numeroDePaginas +
                ", dataPublicacao=" + dataPublicacao +
                ", cadastradoEm=" + cadastradoEm +
                ", autor=" + autor +
                ", categoria=" + categoria +
                '}';
    }
}
