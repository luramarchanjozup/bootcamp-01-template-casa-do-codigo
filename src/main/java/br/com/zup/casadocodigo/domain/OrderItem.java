package br.com.zup.casadocodigo.domain;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Embeddable
public class OrderItem {

    @ManyToOne
    @NotNull
    private Book book;

    @NotNull @Min(1) @Positive
    private int quantity;

    @NotNull @Min(20)
    private BigDecimal priceBook;

    @Deprecated
    public OrderItem() {
    }

    public OrderItem(@NotNull Book book, @NotNull @Min(1) @Positive int quantity) {
        this.book = book;
        this.quantity = quantity;
        this.priceBook = book.getPrice();
    }

    public Book getBook() {
        return book;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal totalValue(){
        return priceBook.multiply(new BigDecimal(quantity));
    }

    }
