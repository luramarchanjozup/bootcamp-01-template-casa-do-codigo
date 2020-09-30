package br.com.casadocodigo.controllers;

import br.com.casadocodigo.dtos.UserDto;
import br.com.casadocodigo.models.Book;
import br.com.casadocodigo.models.Coupon;
import br.com.casadocodigo.models.User;
import br.com.casadocodigo.repositories.BookRepository;
import br.com.casadocodigo.repositories.CouponRepository;
import br.com.casadocodigo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CouponRepository couponRepository;

    @PostMapping("/{userId}/{bookId}")
    public ResponseEntity<UserDto> addBook(@PathVariable Long bookId, @PathVariable Long userId){

        Book book = bookRepository.findById(bookId).orElseThrow();
        User user = userRepository.findById(userId).orElseThrow();

        List<Book> books = user.getShoppingCart();
        books.add(book);

        user.setShoppingCart(books);

        return ResponseEntity.ok(new UserDto(user));

    }

    @PutMapping("/{userId}/{couponId}")
    public ResponseEntity<UserDto> applyCoupon(@PathVariable Long couponId, @PathVariable Long userId){

        Coupon coupon = couponRepository.findById(couponId).orElseThrow();
        User user = userRepository.findById(userId).orElseThrow();

        OffsetDateTime now = OffsetDateTime.now();

        if(coupon.getValidate().isBefore(now)) {

            Double discount = coupon.getDiscount();
            user.setTotalWithoutDiscount(user.getTotal());
            Double total = user.getTotal() * discount;
            user.setTotal(total);

            return ResponseEntity.ok(new UserDto(user));

        }

        return ResponseEntity.notFound().build();

    }
}
