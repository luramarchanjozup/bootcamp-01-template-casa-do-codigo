package bootcamp.challenges.casadocodigo.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;

// Total Intrinsic Load Points: 2
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @NotBlank
    @Column(nullable = false)
    private String title;

    @NotBlank
    @Size(max = 500)
    @Column(nullable = false, length = 500)
    private String synopsis;

    private String summary;

    @NotNull
    @DecimalMin("20.00")
    @Digits(integer=6, fraction=2)
    @Column(nullable = false)
    private BigDecimal price;

    @NotNull
    @Min(100)
    @Column(nullable = false)
    private Integer pages;

    @NotBlank
    @Column(nullable = false)
    private String isbn;

    @Future
    private LocalDate releaseDate;

    @NotNull
    @ManyToOne
    private Category category; // 1 - Category

    @NotNull
    @ManyToOne
    private Author author; // 1 - Author

    @Deprecated
    public Book(){}

    public Book(@NotBlank String title,
                @NotBlank @Size(max = 500) String synopsis,
                String summary,
                @NotBlank @Size(min = 20) BigDecimal price,
                @NotBlank @Size(min = 100) Integer pages,
                @NotBlank String isbn,
                @Future LocalDate releaseDate,
                @NotNull Category category,
                @NotNull Author author) {
        this.title = title;
        this.synopsis = synopsis;
        this.summary = summary;
        this.price = price;
        this.pages = pages;
        this.isbn = isbn;
        this.releaseDate = releaseDate;
        this.category = category;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", summary='" + summary + '\'' +
                ", price=" + price +
                ", pages=" + pages +
                ", isbn='" + isbn + '\'' +
                ", releaseDate=" + releaseDate +
                ", category=" + category +
                ", author=" + author +
                '}';
    }
    @JsonIgnore
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getSummary() {
        return summary;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getPages() {
        return pages;
    }

    public String getIsbn() {
        return isbn;
    }
    @JsonFormat(pattern = "dd/MM/yyyy", shape = STRING)
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public String getCategory() {
        return category.getName();
    }

    public Author getAuthor() {
        return author;
    }
}
