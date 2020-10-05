package br.com.thyagoribeiro.casadocodigo.rest.contract;

import br.com.thyagoribeiro.casadocodigo.domain.Autor;
import br.com.thyagoribeiro.casadocodigo.domain.Categoria;
import br.com.thyagoribeiro.casadocodigo.domain.Livro;
import br.com.thyagoribeiro.casadocodigo.validator.ExistsValue;
import br.com.thyagoribeiro.casadocodigo.validator.ValueStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;

// CDD - Total: 3

public class NovoLivroRequest {

    @NotBlank
    @ExistsValue(domainClass = Livro.class, fieldName = "titulo", valueStatus = ValueStatus.NOT_EXISTS) // CDD 3 - Interface @ExistsValue, classe Livro, ENUM ValueStatus
    String titulo;

    @NotBlank
    @Size(max = 500)
    String resumo;

    String sumario;

    @NotNull
    @Min(20)
    BigDecimal preco;

    @NotNull
    @Min(100)
    int numeroPaginas;

    @NotBlank
    @ExistsValue(domainClass = Livro.class, fieldName = "isbn", valueStatus = ValueStatus.NOT_EXISTS)
    String isbn;

    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    Date dataPublicacao;

    @NotNull
    @ExistsValue(domainClass = Categoria.class, fieldName = "id", valueStatus = ValueStatus.EXISTS)
    Long categoriaId;

    @NotNull
    @ExistsValue(domainClass = Autor.class, fieldName = "id", valueStatus = ValueStatus.EXISTS)
    Long autorId;

    @Deprecated
    public NovoLivroRequest() {
    }

    public NovoLivroRequest(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario, @NotBlank @Size(min = 20) BigDecimal preco, @NotBlank @Size(min = 100) int numeroPaginas, @NotBlank String isbn, @Future Date dataPublicacao, Long categoriaId, Long autorId) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoriaId = categoriaId;
        this.autorId = autorId;
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

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Long getAutorId() {
        return autorId;
    }

    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }

    public Livro toModel() {
        return new Livro(titulo, resumo, sumario, preco, numeroPaginas, isbn, dataPublicacao, categoriaId, autorId);
    }
}
