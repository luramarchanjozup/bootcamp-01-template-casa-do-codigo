package br.com.zup.treinocasadocodigo.entities.livro;

import br.com.zup.treinocasadocodigo.entities.autor.Autor;
import br.com.zup.treinocasadocodigo.entities.categoria.Categoria;
import br.com.zup.treinocasadocodigo.validators.existid.ExistId;
import br.com.zup.treinocasadocodigo.validators.uniquevalue.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Contagem de carga intrínseca da classe: 3
 */

public class LivroNovoRequest {

    @NotBlank
    @UniqueValue(dominioClasse = Livro.class, nomeCampo = "titulo")
    private String titulo;

    @NotBlank
    @Size(max=500)
    private String resumo;

    private String sumario;

    @NotNull
    @Min(20)
    private BigDecimal preco;

    @NotNull
    @Min(100)
    private int nPaginas;

    @NotBlank
    @UniqueValue(dominioClasse = Livro.class, nomeCampo = "isbn")
    private String isbn;

    @NotNull
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;

    @NotNull
    @ExistId(dominioClasse = Categoria.class, nomeCampo = "id")
    private Long idCategoria;

    @NotNull
    @ExistId(dominioClasse = Autor.class, nomeCampo = "id")
    private Long idAutor;

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

    public int getnPaginas() {
        return nPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public Long getIdAutor() {
        return idAutor;
    }

    public Livro toModel(EntityManager manager){
        //1
        Autor autor = manager.find(Autor.class, idAutor);
        //1
        Categoria categoria = manager.find(Categoria.class, idCategoria);

        Assert.notNull(autor, "O Autor não existe");
        Assert.notNull(categoria, "A categoria não existe");

        //1
        return new Livro(titulo, resumo, sumario, preco, nPaginas, isbn, dataPublicacao, categoria, autor);
    }
}
