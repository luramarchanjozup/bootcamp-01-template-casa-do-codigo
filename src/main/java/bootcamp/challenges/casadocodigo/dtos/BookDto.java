package bootcamp.challenges.casadocodigo.dtos;

import bootcamp.challenges.casadocodigo.entities.Author;
import bootcamp.challenges.casadocodigo.entities.Book;
import bootcamp.challenges.casadocodigo.entities.Category;
import bootcamp.challenges.casadocodigo.validators.EntityValueExists;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

// Total Intrinsic Load Points: 4
public class BookDto {
    @NotBlank
    @EntityValueExists(entityClass = Book.class, entityFieldName = "title", message = "já existe e não pode ser duplicado.") // 1 - EntityValueExists
    private final String title;

    @NotBlank
    @Size(max = 500)
    private final String synopsis;

    private String summary;

    @NotNull
    @DecimalMin("20.00")
    @Digits(integer=6, fraction=2)
    private final BigDecimal price;

    @NotNull
    @Min(100)
    private final Integer pages;

    @NotBlank
    @EntityValueExists(entityClass = Book.class, entityFieldName = "isbn", message = "já existe e não pode ser duplicado.")
    private final String isbn;

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    @Future
    private final LocalDate releaseDate;

    @NotNull
    @EntityValueExists(entityClass = Category.class, entityFieldName = "id", expectedAssertion = true, message = "não existe ainda.")
    private final Long categoryId;
    private CategoryDto categoryDto;

    @NotNull
    @EntityValueExists(entityClass = Author.class, entityFieldName = "id", expectedAssertion = true, message = "não existe ainda.")
    private final Long authorId;
    private AuthorDto authorDto;

    public BookDto(@NotBlank String title, @NotBlank @Size(max = 500) String synopsis, String summary, @NotBlank @Size(min = 20) BigDecimal price, @NotBlank @Size(min = 100) Integer pages, @NotBlank String isbn, @Future LocalDate releaseDate, @NotNull Long categoryId, @NotNull Long authorId) {
        this.title = title;
        this.synopsis = synopsis;
        this.summary = summary;
        this.price = price;
        this.pages = pages;
        this.isbn = isbn;
        this.releaseDate = releaseDate;
        this.categoryId = categoryId;
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public String getSynopsis() {
        return synopsis;
    }
    @JsonInclude(JsonInclude.Include.NON_NULL)
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

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public CategoryDto getCategory() {
        return categoryDto;
    }

    public AuthorDto getAuthor() {
        return authorDto;
    }

    public Book toModel(EntityManager entityManager){ // 1 - Book
        @NotNull Author author = entityManager.find(Author.class, authorId); // 1 - Author
        @NotNull Category category = entityManager.find(Category.class, categoryId); // 1 - Category
        return new Book(title, synopsis, summary, price, pages, isbn, releaseDate,category,author);
    }
}
