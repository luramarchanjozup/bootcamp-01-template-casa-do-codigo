package br.com.casadocodigo.model;

import br.com.casadocodigo.validator.ExisteId;
import br.com.casadocodigo.validator.ValorUnico;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class NovoLivroRequest {

    @NotBlank
    @ValorUnico(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    @NotBlank
    private String sumario;

    @NotNull
    @Min(20)
    private BigDecimal preco;

    @NotNull
    @Min(100)
    private int numeroDePaginas;

    @NotBlank
    @ValorUnico(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;

    @NotNull
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataDePublicacao;

    @NotNull
    @ExisteId(domainClass = Categoria.class, fieldName = "id")
    private Long idCategoria;


    @NotNull
    @ExisteId(domainClass = Autor.class, fieldName = "id")
    private Long idAutor;

//    public NovoLivroRequest(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo,
//                            @NotBlank String sumario, @NotBlank @Min(20) BigDecimal preco,
//                            @NotBlank @Min(100) int numeroDePaginas, @NotBlank String isbn,
//                            @NotNull @Future LocalDate dataDePublicacao, @NotNull Long idCategoria,
//                            @NotNull Long idAutor) {
//        this.titulo = titulo;
//        this.resumo = resumo;
//        this.sumario = sumario;
//        this.preco = preco;
//        this.numeroDePaginas = numeroDePaginas;
//        this.isbn = isbn;
//        this.dataDePublicacao = dataDePublicacao;
//        this.idCategoria = idCategoria;
//        this.idAutor = idAutor;
//    }


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

    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public void setNumeroDePaginas(int numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getDataDePublicacao() {
        return dataDePublicacao;
    }

    public void setDataDePublicacao(LocalDate dataDePublicacao) {
        this.dataDePublicacao = dataDePublicacao;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Long getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Long idAutor) {
        this.idAutor = idAutor;
    }

    public Livro toLivro(EntityManager entityManager){
        @NotNull Autor autor = entityManager.find(Autor.class, idAutor);
        @NotNull Categoria categoria = entityManager.find(Categoria.class, idCategoria);

        Assert.state(autor!=null," livro inxistente "+ autor);
        Assert.state(categoria!=null," categoria inexistente "+ categoria);

        return new Livro(titulo, resumo, sumario, preco, numeroDePaginas, isbn,
                dataDePublicacao, autor, categoria);
    }
}
