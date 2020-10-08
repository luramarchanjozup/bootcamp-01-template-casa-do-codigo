package br.com.zup.bootcamp.controller.model;

import br.com.zup.bootcamp.domain.model.Item;

// Intrinsic charge = 1
public class ItemResponse {
    private String id;
    private Integer amount;
    private String book;

    public ItemResponse(){}

    public ItemResponse(Item item) {
        this.id = item.getId();
        this.amount = item.getAmount();
        this.book = item.getBook().getTitle();
    }

    public String getId() {
        return id;
    }

    public Integer getAmount() {
        return amount;
    }

    public String getBook() {
        return book;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void setBook(String book) {
        this.book = book;
    }
}
