package com.bootcamp.cdd.models;



import com.bootcamp.cdd.shared.UniqueValue;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "titulo é obrigatório")
    private String titulo;
    private String sumario;
    @Min(value = 100, message = "O livro deve ter pelo menos 100 paginas")
    private int quantidadePaginas;
    @NotBlank(message = "resumo é obrigatório") @Length(min = 1, max = 500, message = "O resumo deve ter entre 1 e 500 caracteres")
    private String resumo;
    @Min(value = 20, message = "o preço minimo é de 20 reais")
    private BigDecimal preco;
    @NotBlank(message = "Isnb é obrigatorio")
    private String isnb;
    @Future
    private LocalDate dataPublicacao;
    @ManyToOne
    private Author author;
    @ManyToOne
    private Category category;

    public Book(String titulo, String sumario, int quantidadePaginas, String resumo, BigDecimal preco, String isnb, LocalDate dataPublicacao, Author author, Category category) {
        this.titulo = titulo;
        this.sumario = sumario;
        this.quantidadePaginas = quantidadePaginas;
        this.resumo = resumo;
        this.preco = preco;
        this.isnb = isnb;
        this.dataPublicacao = dataPublicacao;
        this.author = author;
        this.category = category;
    }

    public Book() {
    }

    public long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getSumario() {
        return sumario;
    }

    public int getQuantidadePaginas() {
        return quantidadePaginas;
    }

    public String getResumo() {
        return resumo;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getIsnb() {
        return isnb;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Author getAuthor() {
        return author;
    }

    public Category getCategory() {
        return category;
    }

    public long getAuthorId() {
        return this.author.getId();
    }
}
