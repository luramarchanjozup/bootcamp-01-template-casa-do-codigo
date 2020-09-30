package br.com.treino.casadocodigo.model;

import br.com.treino.casadocodigo.validations.ExistId;
import br.com.treino.casadocodigo.validations.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import net.bytebuddy.implementation.bytecode.Throw;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class NovoLivroRequest {

    @UniqueValue(fieldName = "titulo", className = Livro.class ,message = "Esse título já está cadastrado")
    private @NotBlank String titulo;
    private @NotBlank @Size(max = 500) String resumo;
    private @NotBlank String sumario; //obrigatorio?
    private @NotNull @Min(20) BigDecimal preco;
    private @NotNull @Min(100)  Integer numPaginas;
    private @NotBlank @UniqueValue(className = Livro.class, fieldName = "isbn") String isbn;

    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private @Future @NotNull LocalDate dataPublicacao;

    private @NotNull @ExistId(fieldName = "id", className = Categoria.class,
            message = "A categoria com esse ID ainda não existe")
    Long idCategoria;
    private @NotNull @ExistId(fieldName = "id", className = Autor.class,
            message = "O(A) autor(a) com esse ID ainda não existe")
    Long idAutor;

    public NovoLivroRequest(@NotBlank String titulo, @NotBlank @Size(max = 500)
            String resumo, @NotBlank String sumario, @NotNull @Min(20) BigDecimal preco,
                            @NotNull @Min(100) Integer numPaginas,
                            @NotBlank String isbn, @NotNull Long idCategoria, @NotNull Long idAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numPaginas = numPaginas;
        this.isbn = isbn;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
    }

    public Livro toModel(EntityManager entityManager){

        @NotNull Autor autor = entityManager.find(Autor.class, idAutor);
        @NotNull Categoria categoria = entityManager.find(Categoria.class, idCategoria);

        return new Livro(this.titulo, this.resumo, this.sumario,
                this.preco, this.numPaginas, this.isbn, this.dataPublicacao,
                categoria, autor);
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }
}
