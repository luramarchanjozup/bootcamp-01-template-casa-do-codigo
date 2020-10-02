package com.casadocodigo.casaDoCodigo.controllers.dto;

import java.util.List;

import com.casadocodigo.casaDoCodigo.model.CartItem;

public class CartDetails {
    private List<BookPurchaseDto> books;
    private List<CartItem> cartItems;
    private Float finalPrice;
    private Integer quantity;

    public CartDetails() {
    }

    public List<BookPurchaseDto> getBooks() {
        return this.books;
    }

    public void setBooks(BookPurchaseDto books) {
        this.books.add(books);
    }

    public List<CartItem> getCartItems() {
        return this.cartItems;
    }

    public void setCartItems(CartItem cartItems) {
        this.cartItems.add(cartItems);
    }

    public Float getFinalPrice() {
        return this.finalPrice;
    }

    public void setFinalPrice(Float finalPrice) {
        this.finalPrice = finalPrice;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
