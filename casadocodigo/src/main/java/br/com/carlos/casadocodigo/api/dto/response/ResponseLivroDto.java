package br.com.carlos.casadocodigo.api.dto.response;

import br.com.carlos.casadocodigo.domain.entity.Autor;
import br.com.carlos.casadocodigo.domain.entity.Categoria;
import br.com.carlos.casadocodigo.domain.entity.Livro;

import javax.persistence.EntityManager;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ResponseLivroDto {
    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private int paginas;
    private String isbn;
    private LocalDate publicao;
    private ResponseAutorId autor;
    private ResponseCategoriaId categoria;


    public static ResponseLivroDto converter(Livro l){
        var livro = new ResponseLivroDto();
        livro.setTitulo(l.getTitulo());
        livro.setResumo(l.getResumo());
        livro.setSumario(l.getSumario());
        livro.setPreco(l.getPreco());
        livro.setPaginas(l.getPaginas());
        livro.setIsbn(l.getIsbn());
        livro.setPublicao(l.getPublicao());
        livro.setAutor(ResponseAutorId.converter(l.getAutor()));
        livro.setCategoria(ResponseCategoriaId.converter(l.getCategoria()));

        return livro;
    }

    public static Livro builder(Livro livro, EntityManager manager){
        var autor = manager.find(Autor.class, livro.getAutor().getId());
        var categorias = manager.find(Categoria.class, livro.getCategoria().getId());
        livro.setAutor(autor);
        livro.setCategoria(categorias);
        return livro;
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

    public ResponseAutorId getAutor() {
        return autor;
    }

    public void setAutor(ResponseAutorId autor) {
        this.autor = autor;
    }

    public ResponseCategoriaId getCategoria() {
        return categoria;
    }

    public void setCategoria(ResponseCategoriaId categoria) {
        this.categoria = categoria;
    }
}
