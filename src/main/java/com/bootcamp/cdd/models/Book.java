package com.bootcamp.cdd.models;



import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titulo;
    private String sumario;
    private String resumo;
    private double preco;
    private String isnb;
    private LocalDate dataPublicacao;
    @ManyToOne
    private Author author;
    @ManyToOne
    private Category category;

    public Book(String titulo, String sumario, String resumo, double preco, String isnb, LocalDate dataPublicacao, Author author, Category category) {
        this.titulo = titulo;
        this.sumario = sumario;
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

    public String getResumo() {
        return resumo;
    }

    public double getPreco() {
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
}
