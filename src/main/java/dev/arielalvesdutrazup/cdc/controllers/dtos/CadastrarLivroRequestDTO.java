package dev.arielalvesdutrazup.cdc.controllers.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.arielalvesdutrazup.cdc.entities.Livro;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

public class CadastrarLivroRequestDTO {

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
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "{dataPublicacao.notnull}")
    private LocalDate dataPublicacao;
    @NotNull(message = "{categoriaId.notnull}")
    private Long categoriaId;
    @NotNull(message = "{autorId.notnull}")
    private Long autorId;

    public CadastrarLivroRequestDTO() {
    }

    public String getTitulo() {
        return titulo;
    }

    public CadastrarLivroRequestDTO setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public String getResumo() {
        return resumo;
    }

    public CadastrarLivroRequestDTO setResumo(String resumo) {
        this.resumo = resumo;
        return this;
    }

    public String getSumario() {
        return sumario;
    }

    public CadastrarLivroRequestDTO setSumario(String sumario) {
        this.sumario = sumario;
        return this;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public CadastrarLivroRequestDTO setPreco(BigDecimal preco) {
        this.preco = preco;
        return this;
    }

    public Integer getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public CadastrarLivroRequestDTO setNumeroDePaginas(Integer numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
        return this;
    }

    public String getIsbn() {
        return isbn;
    }

    public CadastrarLivroRequestDTO setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public CadastrarLivroRequestDTO setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
        return this;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public CadastrarLivroRequestDTO setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
        return this;
    }

    public Long getAutorId() {
        return autorId;
    }

    public CadastrarLivroRequestDTO setAutorId(Long autorId) {
        this.autorId = autorId;
        return this;
    }

    public Livro paraEntidade() {
        return new Livro()
                .setTitulo(titulo)
                .setResumo(resumo)
                .setSumario(sumario)
                .setNumeroDePaginas(numeroDePaginas)
                .setPreco(preco)
                .setIsbn(isbn)
                .setDataPublicacao(dataPublicacao);
    }
}
