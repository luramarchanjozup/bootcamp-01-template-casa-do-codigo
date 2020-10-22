package br.com.casadocodigo.model;

import br.com.casadocodigo.validator.ExisteId;
import br.com.casadocodigo.validator.ValorUnico;
import com.sun.source.doctree.AuthorTree;
import net.bytebuddy.asm.Advice;
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

    @NotBlank
    @Min(20)
    private BigDecimal preco;

    @NotBlank
    @Min(100)
    private int numeroDePaginas;

    @NotBlank
    @ValorUnico(domainClass = Livro.class, fieldName = "isbn")
    private String isbnLivro;

    @NotNull
    @Future
    private LocalDate dataDePublicacao;

    @NotBlank
    @ExisteId(domainClass = Categoria.class, fieldName = "id")
    private Categoria categoria;


    @NotBlank
    @ExisteId(domainClass = Autor.class, fieldName = "id")
    private Autor autor;

    public NovoLivroRequest(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotBlank String sumario, @NotBlank @Min(20) BigDecimal preco, @NotBlank @Min(100) int numeroDePaginas, @NotBlank String isbnLivro, @NotNull @Future LocalDate dataDePublicacao, @NotBlank Categoria categoria, @NotBlank Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroDePaginas = numeroDePaginas;
        this.isbnLivro = isbnLivro;
        this.dataDePublicacao = dataDePublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }



    public Livro toLivro(EntityManager entityManager){
        @NotNull Autor autor = entityManager.find(Autor.class, autor);
        @NotNull Categoria categoria = entityManager.find(Categoria.class, categoria);

        Assert.state(autor!=null," livro inxistente "+ autor);
        Assert.state(categoria!=null," categoria inexistente "+ categoria);

        return new Livro(titulo, resumo, sumario, preco, numeroDePaginas, isbnLivro,
                dataDePublicacao, autor, categoria);
    }
}
