package com.casadocodigo.casaDoCodigo.controllers.form;

import javax.persistence.EntityManager;
import javax.validation.ValidationException;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.casadocodigo.casaDoCodigo.controllers.dto.BookPurchaseDto;
import com.casadocodigo.casaDoCodigo.controllers.dto.CartDetails;
import com.casadocodigo.casaDoCodigo.model.Book;
import com.casadocodigo.casaDoCodigo.model.CartItem;
import com.casadocodigo.casaDoCodigo.model.Coupon;

public class PurchaseForm {
    @NotNull @NotBlank
    private String name;
    @NotNull @NotBlank
    private String lastName;
    @NotNull @NotBlank @Email
    private String email;
    @NotNull @NotBlank
    private String document;
    @NotNull @NotBlank
    private String address;
    @NotNull @NotBlank
    private String complement;
    @NotNull @NotBlank
    private String city;
    @NotNull @NotBlank
    private String state;
    @NotNull @NotBlank
    private String country;
    @NotNull @NotBlank
    private String phone;
    @NotNull @NotBlank
    private String cep;
    @NotNull
    private CartForm cart;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocument() {
        return this.document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getComplement() {
        return this.complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCep() {
        return this.cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public CartForm getCart() {
        return this.cart;
    }

    public void setCart(CartForm cart) {
        this.cart = cart;
    }

    public CartDetails createCart(EntityManager manager) {
        CartDetails cartDetails = new CartDetails();

        for (CartItemsForm book : this.cart.getItems()) {
            Book bookId = manager.find(Book.class, book.getBookId());
            cartDetails.setBooks(new BookPurchaseDto(bookId));
            cartDetails.setCartItems(new CartItem(book.getBookId(), book.getQuantity()));
            cartDetails.setFinalPrice(bookId, book);
            cartDetails.setQuantity(book);
        }

        if (!this.cart.getCoupon().isBlank()) {
            cartDetails.setCoupon(manager.createQuery("SELECT c FROM Coupon c WHERE c.code = :code", Coupon.class)
                        .setParameter("code", this.cart.getCoupon()).getSingleResult());
        }
                    
        cartDetails.setDiscountedPrice();
        cartDetails.setAppliedCoupon(this.cart.getCoupon());

        if (this.cart.getTotal() != cartDetails.getQuantity()) {
            throw new ValidationException("Cart total does not match the number of items");
        }

        return cartDetails;
    }
}
