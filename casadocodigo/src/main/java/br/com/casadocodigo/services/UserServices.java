package br.com.casadocodigo.services;

import br.com.casadocodigo.models.Book;
import br.com.casadocodigo.models.Coupon;
import br.com.casadocodigo.models.Shop;
import br.com.casadocodigo.repositories.BookRepository;
import br.com.casadocodigo.repositories.CouponRepository;
import br.com.casadocodigo.repositories.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class UserServices {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private CouponRepository couponRepository;


    public Shop couponApplication(Long userId, Long couponId){

        Coupon coupon = couponRepository.findById(couponId).orElseThrow();

        Shop shop = shopRepository.findById(userId).orElseThrow();

        OffsetDateTime now = OffsetDateTime.now();

        if(coupon.getValidate().isBefore(now)) {

            Double discount = coupon.getDiscount();

            shop.setTotalWithoutDiscount(shop.getTotal());

            Double total = shop.getTotal() * discount;

            shop.setTotal(total);

            return shop;

        }

        return null;

    }

    public Shop addToCart(Long bookId, Long userId){

        Book book = bookRepository.findById(bookId).orElseThrow();
        Shop shop = shopRepository.findById(userId).orElseThrow();

        List<Book> books = shop.getShoppingCart();
        books.add(book);

        shop.setShoppingCart(books);

        return shop;
    }
}
