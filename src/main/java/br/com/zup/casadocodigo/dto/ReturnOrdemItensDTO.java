package br.com.zup.casadocodigo.dto;

import br.com.zup.casadocodigo.domain.OrderItem;

import java.math.BigDecimal;

public class ReturnOrdemItensDTO {

    private String book;
    private int quantity;
    private BigDecimal priceBook;

    public ReturnOrdemItensDTO() {
    }

    public static ReturnOrdemItensDTO converter(OrderItem item) {
        var itens = new ReturnOrdemItensDTO();
        itens.setBook(item.getBook().getTitle());
        itens.setQuantity(item.getQuantity());
        itens.setPriceBook(item.getPriceBook());
        return itens;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPriceBook() {
        return priceBook;
    }

    public void setPriceBook(BigDecimal priceBook) {
        this.priceBook = priceBook;
    }
}
