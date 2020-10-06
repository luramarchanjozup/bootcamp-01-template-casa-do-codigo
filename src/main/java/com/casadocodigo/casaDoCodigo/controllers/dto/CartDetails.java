package com.casadocodigo.casaDoCodigo.controllers.dto;

import java.util.ArrayList;
import java.util.List;

import com.casadocodigo.casaDoCodigo.controllers.form.CartItemsForm;
import com.casadocodigo.casaDoCodigo.model.Book;
import com.casadocodigo.casaDoCodigo.model.CartItem;
import com.casadocodigo.casaDoCodigo.model.Coupon;

public class CartDetails {
    private List<BookPurchaseDto> books;
    private List<CartItem> cartItems;
    private Coupon coupon;
    private Float finalPrice;
    private Float discountedPrice;
    private Integer quantity;
    private String appliedCoupon;

    public CartDetails() {
        this.books = new ArrayList<>();
        this.cartItems = new ArrayList<>();
        this.finalPrice = 0f;
        this.discountedPrice = 0f;
        this.quantity = 0;
        this.appliedCoupon = "No coupons applied";
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

    public void setFinalPrice(Book bookId, CartItemsForm cartBook) {
        this.finalPrice = this.finalPrice + bookId.getPrice() * cartBook.getQuantity();
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(CartItemsForm book) {
        this.quantity = this.quantity + book.getQuantity();
    }

    public Coupon getCoupon() {
        return this.coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public Float getDiscountedPrice() {
        return this.discountedPrice;
    }

    public void setDiscountedPrice() {
        this.discountedPrice = this.finalPrice;
        if(this.getCoupon() != null) {
            this.discountedPrice = this.finalPrice - (this.finalPrice * this.coupon.getPercentage());
        }
    }

    public String getAppliedCoupon() {
        return this.appliedCoupon;
    }

    public void setAppliedCoupon(String formCoupon) {
        if(this.coupon != null) {
            this.appliedCoupon = "Coupon code " + this.coupon.getCode() + " with a discount of "
            + (this.coupon.getPercentage() * 100) + "% has been applied";
        } else if (!formCoupon.isBlank()) {
            this.appliedCoupon = "No coupon of code " + formCoupon + " found. No discount applied";
        }
    }

}
