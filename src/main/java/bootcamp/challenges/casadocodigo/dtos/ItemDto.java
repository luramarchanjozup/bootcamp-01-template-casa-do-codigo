package bootcamp.challenges.casadocodigo.dtos;

import bootcamp.challenges.casadocodigo.entities.Book;
import bootcamp.challenges.casadocodigo.entities.Item;
import bootcamp.challenges.casadocodigo.validators.EntityValueExists;
import org.springframework.validation.annotation.Validated;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
@Validated
public final class ItemDto {
    @NotNull
    @EntityValueExists(entityClass = Book.class, entityFieldName = "id", expectedAssertion = true, message = "não existe ainda.")
    private final Long bookId;
    @NotNull
    @Min(1)
    private final Integer amount;

    public ItemDto(@NotNull Long bookId, @NotNull @Min(1) Integer amount) {
        this.bookId = bookId;
        this.amount = amount;
    }

    public Long getBookId() {
        return bookId;
    }

    public Integer getAmount() {
        return amount;
    }
    @Valid
    public Item toModel(EntityManager entityManager){
        @EntityValueExists(entityClass = Book.class, entityFieldName = "id", expectedAssertion = true, message = "não existe ainda.")
        Book book = entityManager.find(Book.class, bookId);
        return new Item(book, amount);
    }

}
