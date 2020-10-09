package br.com.zup.bootcamp.controller.model;

import br.com.zup.bootcamp.controller.validator.annotation.Exist;
import br.com.zup.bootcamp.domain.model.Book;
import br.com.zup.bootcamp.domain.model.Item;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

// Intrinsic charge = 2
public class ItemRequest {
    @NotBlank(message = "Book is mandatory")
    @Exist(message = "Book not found", fieldName = "id", domainClass = Book.class)
    private String book;

    @NotNull(message = "Amount is mandatory")
    @Min(value = 1, message = "Amount must be greater or equal 1")
    private int amount;

    public String getBook() {
        return book;
    }

    public int getAmount() {
        return amount;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public void setAmount(@NotNull @Min(1) int amount) {
        this.amount = amount;
    }

    public Item convert(){
        Item item = new Item();
        item.setAmount(this.amount);

        Book book = new Book();
        book.setIsbn(this.book);

        item.setBook(book);
        return item;
    }
}
