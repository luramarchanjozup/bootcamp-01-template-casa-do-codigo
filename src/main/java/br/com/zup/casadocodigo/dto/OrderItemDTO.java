package br.com.zup.casadocodigo.dto;

import br.com.zup.casadocodigo.annotations.ExistsValue;
import br.com.zup.casadocodigo.domain.Book;
import br.com.zup.casadocodigo.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class OrderItemDTO {

    @NotNull
    @ExistsValue(domainClass = Book.class, fieldName = "id")
    private Long bookId;

    @Positive
    private int quantity;

    public OrderItemDTO(@NotNull Long bookId, @Positive int quantity) {
        this.bookId = bookId;
        this.quantity = quantity;
    }

    public Long getBookId() {
        return bookId;
    }

    public OrderItem toModel(EntityManager manager) {
        @NotNull Book book = manager.find(Book.class, bookId);
        return new OrderItem(book, quantity);
    }
}
