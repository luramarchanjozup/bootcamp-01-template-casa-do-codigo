package com.casadocodigo.casaDoCodigo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.casadocodigo.casaDoCodigo.controllers.dto.BookPurchaseDto;
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

        List<BookPurchaseDto> books = new ArrayList<>();
        List<CartItem> cartItems = new ArrayList<>();
        String appliedCoupon = "No coupons were applied";
        float discountedPrice = 0f;
        float finalPrice = 0f;
        int quantity = 0;

        for (CartItemsForm book : form.getCart().getItems()) {
            Optional<Book> possibleBook = bookRepository.findById(book.getBookId());
            books.add(new BookPurchaseDto(possibleBook.orElseThrow(
                                    () -> new ObjectNotFoundException("Book of id " + book.getBookId() + " not found"))));
            cartItems.add(new CartItem(book.getBookId(), book.getQuantity()));
            finalPrice += possibleBook.get().getPrice() * book.getQuantity();
            quantity += book.getQuantity();
        }

        if (form.getCart().getTotal() != quantity) {
            throw new PurchaseException("Cart total does not match the number of items");
        }

        if (!form.getCart().getCoupon().isBlank()) {
            Optional<Coupon> couponObj = couponRepository.findByCode(form.getCart().getCoupon());
            if(couponObj.isPresent()) {
                discountedPrice = finalPrice - (finalPrice * couponObj.get().getPercentage());
                appliedCoupon = "Coupon code " + form.getCart().getCoupon() + " with a discount of " + 
                                (couponObj.get().getPercentage() * 100) + "% has been applied";
            } else {
                discountedPrice = finalPrice;
                appliedCoupon = "No coupon of code " + form.getCart().getCoupon() + " found. No discount applied";
            }
        }

        Cart cart = new Cart(quantity, cartItems);

        Optional<Country> countryObj = countryRepository.findByName(form.getCountry());
        Optional<State> stateObj = stateRepository.findByName(form.getState());

        Purchases purchase = new Purchases(form, 
                                        stateObj.orElseThrow(() -> new ObjectNotFoundException(exceptionMsg("State", form.getState()))),
                                        countryObj.orElseThrow(() -> new ObjectNotFoundException(exceptionMsg("Country", form.getCountry()))),
                                        cart);

        purchaseRepository.save(purchase);

        return new PurchaseDto(purchase, books, finalPrice, discountedPrice, appliedCoupon);
    }

    private String exceptionMsg(String type, String name) {
        return type + " of name " + name + " not found";
    }
}
