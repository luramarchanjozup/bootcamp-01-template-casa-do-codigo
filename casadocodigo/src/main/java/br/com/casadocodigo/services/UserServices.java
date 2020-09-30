package br.com.casadocodigo.services;

import br.com.casadocodigo.dtos.UserDto;
import br.com.casadocodigo.models.Book;
import br.com.casadocodigo.models.Coupon;
import br.com.casadocodigo.models.User;
import br.com.casadocodigo.repositories.BookRepository;
import br.com.casadocodigo.repositories.CouponRepository;
import br.com.casadocodigo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CouponRepository couponRepository;


    public User couponApplication(Long userId, Long couponId){

        Coupon coupon = couponRepository.findById(couponId).orElseThrow();

        User user = userRepository.findById(userId).orElseThrow();

        OffsetDateTime now = OffsetDateTime.now();

        if(coupon.getValidate().isBefore(now)) {

            Double discount = coupon.getDiscount();

            user.setTotalWithoutDiscount(user.getTotal());

            Double total = user.getTotal() * discount;

            user.setTotal(total);

            return user;

        }

        return null;

    }

    public User addToCart(Long bookId, Long userId){

        Book book = bookRepository.findById(bookId).orElseThrow();
        User user = userRepository.findById(userId).orElseThrow();

        List<Book> books = user.getShoppingCart();
        books.add(book);

        user.setShoppingCart(books);

        return user;
    }
}
