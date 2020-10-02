package com.casadocodigo.casaDoCodigo.services;

import javax.transaction.Transactional;

import com.casadocodigo.casaDoCodigo.controllers.dto.BookPurchaseDto;
import com.casadocodigo.casaDoCodigo.controllers.dto.CartDetails;
import com.casadocodigo.casaDoCodigo.controllers.dto.PurchaseDto;
import com.casadocodigo.casaDoCodigo.controllers.form.CartItemsForm;
import com.casadocodigo.casaDoCodigo.controllers.form.PurchaseForm;
import com.casadocodigo.casaDoCodigo.model.Cart;
import com.casadocodigo.casaDoCodigo.model.CartItem;
import com.casadocodigo.casaDoCodigo.model.Purchases;
import com.casadocodigo.casaDoCodigo.repositories.BookRepository;
import com.casadocodigo.casaDoCodigo.repositories.CountryRepository;
import com.casadocodigo.casaDoCodigo.repositories.CouponRepository;
import com.casadocodigo.casaDoCodigo.repositories.PurchaseRepository;
import com.casadocodigo.casaDoCodigo.repositories.StateRepository;
import com.casadocodigo.casaDoCodigo.services.exceptions.ObjectNotFoundException;
import com.casadocodigo.casaDoCodigo.services.exceptions.PurchaseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchasesServices {

    @Autowired
    private PurchaseRepository purchaseRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CouponRepository couponRepository;

    @Transactional
    public PurchaseDto createPurchase(PurchaseForm form) {
        CartDetails cartDetails = cartDetails(form);

        if (form.getCart().getTotal() != cartDetails.getQuantity()) {
            throw new PurchaseException("Cart total does not match the number of items");
        }

        float discountedPrice = applyCoupon(form, cartDetails);
        String appliedCoupon = couponMessage(form);

        Purchases purchase = new Purchases(form,
            stateRepository.findByName(form.getState()).orElseThrow(
                () -> new ObjectNotFoundException(exceptionMsg("State", form.getState()))),
            countryRepository.findByName(form.getCountry()).orElseThrow(
                () -> new ObjectNotFoundException(exceptionMsg("Country", form.getCountry()))),
            new Cart(cartDetails.getQuantity(), cartDetails.getCartItems()));

        purchaseRepository.save(purchase);

        return new PurchaseDto(purchase, cartDetails.getBooks(), cartDetails.getFinalPrice(), discountedPrice, appliedCoupon);
    }

    private CartDetails cartDetails(PurchaseForm form) {
        CartDetails cartDetails = new CartDetails();

        for (CartItemsForm book : form.getCart().getItems()) {
            cartDetails.setBooks(new BookPurchaseDto(bookRepository.findById(book.getBookId())
                    .orElseThrow(() -> new ObjectNotFoundException("Book of id " + book.getBookId() + " not found"))));
            cartDetails.setCartItems(new CartItem(book.getBookId(), book.getQuantity()));
            cartDetails.setFinalPrice(cartDetails.getFinalPrice()
                    + bookRepository.findById(book.getBookId()).get().getPrice() * book.getQuantity());
            cartDetails.setQuantity(cartDetails.getQuantity() + book.getQuantity());
        }

        return cartDetails;
    }

    private float applyCoupon(PurchaseForm form, CartDetails cart) {
        float discountedPrice = cart.getFinalPrice();

        if (!form.getCart().getCoupon().isBlank() && couponRepository.findByCode(form.getCart().getCoupon()).isPresent()) {
            discountedPrice = cart.getFinalPrice() - (cart.getFinalPrice()
                    * couponRepository.findByCode(form.getCart().getCoupon()).get().getPercentage());
        }

        return discountedPrice;
    }

    private String couponMessage(PurchaseForm form) {
        String appliedCoupon = "No coupons applied";

        if(couponRepository.findByCode(form.getCart().getCoupon()).isPresent()) {
            appliedCoupon = "Coupon code " + form.getCart().getCoupon() + " with a discount of "
                + (couponRepository.findByCode(form.getCart().getCoupon()).get().getPercentage() * 100) + "% has been applied";
        } else if (!form.getCart().getCoupon().isBlank()) {
            appliedCoupon = "No coupon of code " + form.getCart().getCoupon() + " found. No discount applied";
        }
        return appliedCoupon;
    }

    private String exceptionMsg(String type, String name) {
        return type + " of name " + name + " not found";
    }
}