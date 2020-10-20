package br.com.zup.casadocodigo.domain;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String resume;
    private String summary;
    private BigDecimal price;
    private int numberPages;
    private String isbn;
    private LocalDate datePublish;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Author author;

    @Deprecated
    public Book() {
    }

    public Book(@NotBlank String title, @NotBlank @Size(max = 500) String resume, @NotBlank String summary,
                @NotNull @Min(20) BigDecimal price,
                @NotNull @Min(100) int numberPages,
                @NotBlank String isbn,
                @Future @NotNull LocalDate datePublish,
                @NotNull Category category,
                @NotNull Author author) {
        this.title = title;
        this.resume = resume;
        this.summary = summary;
        this.price = price;
        this.numberPages = numberPages;
        this.isbn = isbn;
        this.datePublish = datePublish;
        this.category = category;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getNumberPages() {
        return numberPages;
    }

    public void setNumberPages(int numberPages) {
        this.numberPages = numberPages;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getDatePublish() {
        return datePublish;
    }

    public void setDatePublish(LocalDate datePublish) {
        this.datePublish = datePublish;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
