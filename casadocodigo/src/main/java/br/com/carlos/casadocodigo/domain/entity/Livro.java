package br.com.carlos.casadocodigo.domain.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String titulo;

    @Column(nullable = false, length = 500)
    private String resumo;

    @Column(columnDefinition="TEXT")
    private String sumario;

    @Column(nullable = false)
    private BigDecimal preco;

    @Column(nullable = false)
    private int paginas;

    @Column(nullable = false, unique = true)
    private String isbn;

    @Column(nullable = false)
    private LocalDate publicao;

    @ManyToOne
    private  Autor autor;

    @ManyToOne
    private Categoria categoria;

    @Deprecated
    public Livro(){}

    public Livro(String titulo, String resumo, String sumario, BigDecimal preco, Integer paginas, String isbn,
                 LocalDate publicao, Autor autor, Categoria categoria) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.paginas = paginas;
        this.isbn = isbn;
        this.publicao = publicao;
        this.autor = autor;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
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

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}


