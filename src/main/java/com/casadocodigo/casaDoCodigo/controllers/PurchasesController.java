package com.casadocodigo.casaDoCodigo.controllers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.ValidationException;

import com.casadocodigo.casaDoCodigo.controllers.dto.BookPurchaseDto;
import com.casadocodigo.casaDoCodigo.controllers.dto.CartDetails;
import com.casadocodigo.casaDoCodigo.controllers.dto.PurchaseDto;
import com.casadocodigo.casaDoCodigo.controllers.form.CartItemsForm;
import com.casadocodigo.casaDoCodigo.controllers.form.PurchaseForm;
import com.casadocodigo.casaDoCodigo.model.Book;
import com.casadocodigo.casaDoCodigo.model.Cart;
import com.casadocodigo.casaDoCodigo.model.CartItem;
import com.casadocodigo.casaDoCodigo.model.Country;
import com.casadocodigo.casaDoCodigo.model.Coupon;
import com.casadocodigo.casaDoCodigo.model.Purchases;
import com.casadocodigo.casaDoCodigo.model.State;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchase")
public class PurchasesController {

    @PersistenceContext
    private EntityManager manager;
    
    @PostMapping
    @Transactional
    public ResponseEntity<PurchaseDto> createPurchase(@RequestBody @Valid PurchaseForm form) {
        CartDetails cartDetails = cartDetails(form);

        if (form.getCart().getTotal() != cartDetails.getQuantity()) {
            throw new ValidationException("Cart total does not match the number of items");
        }

        Coupon coupon = manager.createQuery("SELECT c FROM Coupon c WHERE c.code = :code", Coupon.class)
                        .setParameter("code", form.getCart().getCoupon()).getSingleResult();
        
        float discountedPrice = applyCoupon(form, cartDetails, coupon);
        String appliedCoupon = couponMessage(form, coupon);

        State state = manager.createQuery("SELECT s FROM State s WHERE s.name = :name", State.class)
            .setParameter("name", form.getState()).getSingleResult();
        Country country = manager.createQuery("SELECT c FROM Country c WHERE c.name = :name", Country.class)
        .setParameter("name", form.getCountry()).getSingleResult();

        Purchases purchase = new Purchases(form, state, country, new Cart(cartDetails.getQuantity(), cartDetails.getCartItems()));

        manager.persist(purchase);

        return ResponseEntity.ok().body(
            new PurchaseDto(purchase, cartDetails.getBooks(), cartDetails.getFinalPrice(), discountedPrice, appliedCoupon));
    }

    private CartDetails cartDetails(PurchaseForm form) {
        CartDetails cartDetails = new CartDetails();

        for (CartItemsForm book : form.getCart().getItems()) {
            Book bookId = manager.find(Book.class, book.getBookId());
            cartDetails.setBooks(new BookPurchaseDto(bookId));
            cartDetails.setCartItems(new CartItem(book.getBookId(), book.getQuantity()));
            cartDetails.setFinalPrice(cartDetails.getFinalPrice()
                    + manager.find(Book.class, book.getBookId()).getPrice() * book.getQuantity());
            cartDetails.setQuantity(cartDetails.getQuantity() + book.getQuantity());
        }

        return cartDetails;
    }

    private float applyCoupon(PurchaseForm form, CartDetails cart, Coupon coupon) {
        float discountedPrice = cart.getFinalPrice();
        
        System.out.println("----------------------");
        System.out.println(coupon);
        System.out.println("----------------------");

        if (!form.getCart().getCoupon().isBlank() && coupon != null) {
            discountedPrice = cart.getFinalPrice() - (cart.getFinalPrice() * coupon.getPercentage());
        }

        return discountedPrice;
    }

    private String couponMessage(PurchaseForm form, Coupon coupon) {
        String appliedCoupon = "No coupons applied";

        if(coupon != null) {
            appliedCoupon = "Coupon code " + form.getCart().getCoupon() + " with a discount of "
                + (coupon.getPercentage() * 100) + "% has been applied";
        } else if (!form.getCart().getCoupon().isBlank()) {
            appliedCoupon = "No coupon of code " + form.getCart().getCoupon() + " found. No discount applied";
        }
        return appliedCoupon;
    }
}
