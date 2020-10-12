package dev.arielalvesdutrazup.cdc.controllers.dtos;

import dev.arielalvesdutrazup.cdc.entities.Livro;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LivroResponseDTO {

    private Long id;
    private String titulo;
    private String resumo;
    private String sumario;
    private String isbn;
    private BigDecimal preco;
    private Integer numeroDePaginas;
    private LocalDate dataPublicacao;
    private OffsetDateTime cadastradoEm;

    public LivroResponseDTO() {
    }

    public LivroResponseDTO(Livro livro) {
        setId(livro.getId());
        setTitulo(livro.getTitulo());
        setResumo(livro.getResumo());
        setSumario(livro.getSumario());
        setIsbn(livro.getIsbn());
        setPreco(livro.getPreco());
        setDataPublicacao(livro.getDataPublicacao());
        setNumeroDePaginas(livro.getNumeroDePaginas());
        setCadastradoEm(livro.getCadastradoEm());
    }

    public Long getId() {
        return id;
    }

    public LivroResponseDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitulo() {
        return titulo;
    }

    public LivroResponseDTO setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public String getResumo() {
        return resumo;
    }

    public LivroResponseDTO setResumo(String resumo) {
        this.resumo = resumo;
        return this;
    }

    public String getSumario() {
        return sumario;
    }

    public LivroResponseDTO setSumario(String sumario) {
        this.sumario = sumario;
        return this;
    }

    public String getIsbn() {
        return isbn;
    }

    public LivroResponseDTO setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public LivroResponseDTO setPreco(BigDecimal preco) {
        this.preco = preco;
        return this;
    }

    public Integer getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public LivroResponseDTO setNumeroDePaginas(Integer numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
        return this;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public LivroResponseDTO setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
        return this;
    }

    public OffsetDateTime getCadastradoEm() {
        return cadastradoEm;
    }

    public LivroResponseDTO setCadastradoEm(OffsetDateTime cadastradoEm) {
        this.cadastradoEm = cadastradoEm;
        return this;
    }

    public static List<LivroResponseDTO> paraDTO(List<Livro> livros) {
        return livros.stream().map(LivroResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "LivroResponseDTO{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", resumo='" + resumo + '\'' +
                ", sumario='" + sumario + '\'' +
                ", isbn='" + isbn + '\'' +
                ", preco=" + preco +
                ", numeroDePaginas=" + numeroDePaginas +
                ", dataPublicacao=" + dataPublicacao +
                ", cadastradoEm=" + cadastradoEm +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LivroResponseDTO that = (LivroResponseDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(titulo, that.titulo) &&
                Objects.equals(resumo, that.resumo) &&
                Objects.equals(sumario, that.sumario) &&
                Objects.equals(isbn, that.isbn) &&
                Objects.equals(preco, that.preco) &&
                Objects.equals(numeroDePaginas, that.numeroDePaginas) &&
                Objects.equals(dataPublicacao, that.dataPublicacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, resumo, sumario, isbn, preco, numeroDePaginas, dataPublicacao);
    }
}
