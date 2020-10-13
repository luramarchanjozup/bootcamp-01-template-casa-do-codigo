package io.github.evertoncnsouza.rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.evertoncnsouza.domain.entity.Autor;
import io.github.evertoncnsouza.domain.entity.Categoria;
import io.github.evertoncnsouza.domain.entity.Livro;
import io.github.evertoncnsouza.validation.constraint.valitation.ExistsId;
import io.github.evertoncnsouza.validation.constraint.valitation.UniqueValue;
import org.springframework.util.Assert;
import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroRequest {

    @NotBlank(message = "{campo.titulo.obrigatorio}")
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;

    @NotBlank(message = "{campo.resumo.obrigatorio}") @Size(max = 500)
    private String resumo;

    @NotBlank
    private String sumario;

    @NotNull(message = "{campo.preco.obrigatorio}")
    @Min(20)
    private BigDecimal preco;

    @Min(100)
    @NotNull(message = "{numero.paginas.obrigatorio}")
    private int numeroPaginas;

    @NotBlank(message = "{informe.codigo.isbn}")
    @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;

    @NotNull
    @Future //Annotation para ser aceita data no futuro;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;

    @NotNull
    @ExistsId(domainClass = Categoria.class, fieldName = "id")
    private Long idCategoria;
    //PCI 1;

    @NotNull
    @ExistsId(domainClass = Autor.class, fieldName = "id")
    private Long idAutor;
    //PCI 2;

    public LivroRequest(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo,
                        @NotBlank String sumario, @NotNull @Min(20) BigDecimal preco,
                        @Min(100) int numeroPaginas, @NotBlank String isbn,
                        @NotNull Long idCategoria, @NotNull Long idAutor) {
        super(); //Chama o construtor da classa mãe;
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
    }

   public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }
    //Entity manager para persistência junto a classe autor e categoria, para buscaram por id;
    public Livro toModel(EntityManager manager) {
    @NotNull Autor autor = manager.find(Autor.class, idAutor);
    @NotNull Categoria categoria = manager.find(Categoria.class, idCategoria);
    //PCI 3;


    Assert.state(autor!=null, "Voce esta cadastrando livro para autor que nao existe");
    Assert.state(categoria!=null,"Esta categoria de livro nao existe");
    //PCI 4 e 5; Entendi que este método é mais para o dev do que pro usuario que faz a requisição.

    return new Livro(titulo, resumo, sumario, preco, numeroPaginas, isbn, dataPublicacao, autor, categoria);
    }
}