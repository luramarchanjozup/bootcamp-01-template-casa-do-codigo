package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.response;

import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.Livro;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

public class DetalhesLivroResponse {

    @NotBlank
    private String titulo;
    @NotBlank
    @Size(max = 400)
    private String resumo;
    private String sumario;
    @Min(20)
    private BigDecimal preco;
    @NotNull
    @Min(100)
    private Integer paginas;
    @NotBlank
    private String isbn;
    @NotNull
    private Date dataLancamento;

    //Dados do Autor
    @NotBlank
    private String nomeAutor;
    @NotBlank
    private String resumoAutor;

    @Deprecated
    public DetalhesLivroResponse(){

    }

    public DetalhesLivroResponse(Livro livro) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.paginas = livro.getPaginas();
        this.isbn = livro.getIsbn();
        this.nomeAutor = livro.getAutor().getNome();
        this.resumoAutor = livro.getAutor().getDescricao();
        this.dataLancamento = livro.getDataLancamento();
    }

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

    public Integer getPaginas() {
        return paginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public String getResumoAutor() {
        return resumoAutor;
    }
}
