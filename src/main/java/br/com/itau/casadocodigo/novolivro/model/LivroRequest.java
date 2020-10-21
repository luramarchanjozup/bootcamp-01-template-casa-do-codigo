package br.com.itau.casadocodigo.novolivro.model;

import br.com.itau.casadocodigo.cadastrocategoria.model.Categoria;
import br.com.itau.casadocodigo.novoautor.model.Autor;
import br.com.itau.casadocodigo.validador.AtributoNaoExistente;
import br.com.itau.casadocodigo.validador.AtributoUnico;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroRequest {

    @NotBlank
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
    private int numeroPaginas;
    @NotBlank
    @AtributoUnico(nomeDoAtributo = "isbn", classeDeDominio = Livro.class)
    private String isbn;
    @NotNull
    @Future
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataLancamento;
    @NotNull
    @AtributoNaoExistente(nomeDoAtributo = "id", classeDeDominio = Autor.class)
    private Long idAutor;
    @NotNull
    @AtributoNaoExistente(nomeDoAtributo = "id", classeDeDominio = Categoria.class)
    private Long idCategoria;

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public Long getIdAutor() {
        return idAutor;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }
//1
    public Livro toModel(EntityManager entityManager){
        Autor autor = entityManager.find(Autor.class, this.idAutor);
        Categoria categoria = entityManager.find(Categoria.class, this.idCategoria);

        return new Livro(this.titulo, this.resumo, this.sumario, this.preco, this.numeroPaginas,
                this.isbn, this.dataLancamento, autor, categoria);
    }
}
