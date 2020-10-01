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

    //+1
    @Autowired
    private BookRepository bookRepository;

    //+1
    @Autowired
    private ShopRepository shopRepository;

    //+1
    @Autowired
    private CouponRepository couponRepository;


    public Shop couponApplication(Long userId, Long couponId){

        //+1
        Coupon coupon = couponRepository.findById(couponId).orElseThrow();

        //+1
        Shop shop = shopRepository.findById(userId).orElseThrow();

        OffsetDateTime now = OffsetDateTime.now();

        //+1
        if(coupon.getValidate().isBefore(now)) {

            //+1
            shop.setTotalWithoutDiscount(shop.getTotal());
            shop.setTotal(shop.getTotal() * coupon.getDiscount());

            return shop;
        }

        return null;

    }

    public Shop addToCart(Long bookId, Long userId){

        //+1
        Book book = bookRepository.findById(bookId).orElseThrow();

        //+1
        Shop shop = shopRepository.findById(userId).orElseThrow();

        //+1
        List<Book> books = shop.getShoppingCart();
        books.add(book);

        //+1
        shop.setShoppingCart(books);

        return shop;
    }
}
