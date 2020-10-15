package br.com.carlos.casadocodigo.api.dto.request;

import br.com.carlos.casadocodigo.api.handler.Unique;
import br.com.carlos.casadocodigo.domain.entity.Autor;
import br.com.carlos.casadocodigo.domain.entity.Categoria;
import br.com.carlos.casadocodigo.domain.entity.Livro;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class RequestLivroDto {

    @NotBlank(message = "é obrigatorio") @Unique(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;

    @NotBlank(message = "é obrigatorio") @Size(max = 500, message = "limite de 500 carateres")
    private String resumo;

    @NotNull(message = "é obrigatorio")
    private String sumario;

    @Min(value = 20, message = "deve ser maior ou igual a 20")
    private BigDecimal preco;

    @Min(value = 100, message = "deve ser maior ou igual a 100")
    private int paginas;

    @NotBlank(message = "é obrigatorio") @Unique(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;

    @Future(message = "deve ser uma data no futuro")
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate publicao;

    @Valid
    @NotNull(message = "é obrigatorio")
    private RequestAutorId autor;

    @Valid
    @NotNull(message = "é obrigatorio")
    private RequestCategoriaId categoria;

    public RequestLivroDto() {
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

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getPublicao() {
        return publicao;
    }

    public void setPublicao(LocalDate publicao) {
        this.publicao = publicao;
    }

    public RequestAutorId getAutor() {
        return autor;
    }

    public void setAutor(RequestAutorId autor) {
        this.autor = autor;
    }

    public RequestCategoriaId getCategoria() {
        return categoria;
    }

    public void setCategoria(RequestCategoriaId categoria) {
        this.categoria = categoria;
    }

    public Livro toEntity(EntityManager manager) {
        var autor = manager.find(Autor.class, this.autor.getId());
        var categoria = manager.find(Categoria.class, this.categoria.getId());
        return new Livro(titulo, resumo, sumario, preco, paginas, isbn,
                publicao, autor, categoria);
    }
}
