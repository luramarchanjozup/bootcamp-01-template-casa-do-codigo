package br.com.zup.casadocodigo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
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

    public String getTitle() {
        return title;
    }

    public String getResume() {
        return resume;
    }

    public String getSummary() {
        return summary;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getNumberPages() {
        return numberPages;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDatePublish() {
        return datePublish;
    }

    public Author getAuthor() {
        return author;
    }
}
