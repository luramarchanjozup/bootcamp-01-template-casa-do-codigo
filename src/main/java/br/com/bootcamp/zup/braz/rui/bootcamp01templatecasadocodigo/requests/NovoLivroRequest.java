package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.requests;

import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.annotation.ObjetoValido;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.Autor;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.Categoria;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.Livro;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.annotation.ObjetoUnico;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
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
    @Future
    private Date dataLancamento;
    @NotNull
    @ObjetoValido(domainClass = Categoria.class, fieldName = "id")
    private Integer idCategoria;
    @ObjetoValido(domainClass = Autor.class, fieldName = "id")
    @NotNull
    private Integer idAutor;



    @Deprecated
    public NovoLivroRequest(){
        }

    public NovoLivroRequest(@NotBlank String titulo, @NotBlank @Size(max = 400) String resumo, String sumario, @NotNull @Min(20) BigDecimal preco, @NotNull @Min(100) Integer paginas, @NotBlank String isbn, @NotNull Date dataLancamento, @NotNull Integer idCategoria, @NotNull Integer idAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.paginas = paginas;
        this.isbn = isbn;
        this.dataLancamento = dataLancamento;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
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

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Integer getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Integer idAutor) {
        this.idAutor = idAutor;
    }

    public Livro toModel(EntityManager entityManager) {
        @NotNull Categoria categoria = entityManager.find(Categoria.class, idCategoria); //1
        @NotNull Autor autor = entityManager.find(Autor.class, idAutor); //1

        return new Livro(titulo, resumo, sumario, preco, paginas, isbn, dataLancamento, categoria, autor); //1
    }
}
