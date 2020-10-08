package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.requests;

import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.Autor;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.Categoria;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.Livro;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.validation.ObjetoUnico;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

public class NovoLivroRequest {
    @NotBlank
    @ObjetoUnico(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;
    @NotBlank
    @Size(max = 400)
    private String resumo;
    private String sumario;
    @NotNull
    @Min(20)
    private BigDecimal preco;
    @NotNull
    @Min(100)
    private Integer paginas;
    @NotBlank
    @ObjetoUnico(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;
    @NotNull
    private Date dataLancamento;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "id_autor")
    private Autor autor;

    public Livro toModel() {
        return new Livro(this.titulo, this.resumo, this.sumario, this.preco, this.paginas, this.isbn, this.dataLancamento, this.categoria, this.autor);
    }

    public boolean validaNovoLivro(String categoriaNome, String autorEmail){

        return false;
    }
}
