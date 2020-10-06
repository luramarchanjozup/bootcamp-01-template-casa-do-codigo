package br.com.ecommerce.cdc.domain.request;

import br.com.ecommerce.cdc.anotacao.ExistInDataBase;
import br.com.ecommerce.cdc.anotacao.NotDuplicated;
import br.com.ecommerce.cdc.domain.model.Autor;
import br.com.ecommerce.cdc.domain.model.Categoria;
import br.com.ecommerce.cdc.domain.model.Livro;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroRequest {

    @NotBlank
    @NotDuplicated(nameClass = "Livro", fieldName = "titulo")
    private String titulo;
    @NotBlank @Size(max = 500)
    private String resumo;
    private String sumario;
    @NotNull @Min(20)
    private BigDecimal preco;
    @NotNull @Positive
    private Integer numPagina;
    @NotDuplicated(fieldName = "isbn",nameClass = "Livro")
    @NotBlank
    private String isbn;
    @JsonFormat(pattern = "yyyy/MM/dd", shape = JsonFormat.Shape.STRING)
    @Future
    @NotNull
    private LocalDate dataPublicacao;
    @NotNull
    @ExistInDataBase(nameFieldClass = Autor.class, nameClass = "Autor")
    private Long autor;
    @NotNull
    @ExistInDataBase(nameFieldClass = Categoria.class, nameClass = "Categoria")
    private Long categoria;

    public LivroRequest() {
    }

    public LivroRequest(String titulo, String resumo, String sumario, BigDecimal preco, Integer numPagina, String isbn, LocalDate dataPublicacao, Long autor, Long categoria) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numPagina = numPagina;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.autor = autor;
        this.categoria = categoria;
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

    public Integer getNumPagina() {
        return numPagina;
    }

    public void setNumPagina(Integer numPagina) {
        this.numPagina = numPagina;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Long getAutor() {
        return autor;
    }

    public void setAutor(Long autor) {
        this.autor = autor;
    }

    public Long getCategoria() {
        return categoria;
    }

    public void setCategoria(Long categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "LivroRequest{" +
                "titulo='" + titulo + '\'' +
                ", resumo='" + resumo + '\'' +
                ", sumario='" + sumario + '\'' +
                ", preco=" + preco +
                ", numPagina=" + numPagina +
                ", isbn='" + isbn + '\'' +
                ", dataPublicacao=" + dataPublicacao +
                ", autor=" + autor +
                ", categoria=" + categoria +
                '}';
    }

    public Livro toModel(Autor autor, Categoria categoria){
        return new Livro(this.getTitulo(),this.getResumo(),this.sumario,this.preco,this.numPagina,this.isbn,this.dataPublicacao, autor, categoria);
    }
}
