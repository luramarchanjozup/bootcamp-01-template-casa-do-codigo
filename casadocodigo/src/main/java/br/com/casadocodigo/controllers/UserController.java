package br.com.casadocodigo.controllers;

import br.com.casadocodigo.dtos.UserDto;
import br.com.casadocodigo.models.Book;
import br.com.casadocodigo.models.Coupon;
import br.com.casadocodigo.models.User;
import br.com.casadocodigo.repositories.BookRepository;
import br.com.casadocodigo.repositories.CouponRepository;
import br.com.casadocodigo.repositories.UserRepository;
import br.com.casadocodigo.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServices userServices;


    @PostMapping("/{userId}/{bookId}")
    public ResponseEntity<UserDto> addBook(@PathVariable Long bookId, @PathVariable Long userId){

        User user = userServices.addToCart(bookId, userId);

        if(user != null) {
            return ResponseEntity.ok(new UserDto(user));
        }

        return ResponseEntity.notFound().build();

    }

    @PutMapping("/{userId}/{couponId}")
    public ResponseEntity<UserDto> applyCoupon(@PathVariable Long couponId, @PathVariable Long userId){

        User user = userServices.couponApplication(couponId, userId);

        if(user != null) {
            return ResponseEntity.ok(new UserDto(user));
        }

        return ResponseEntity.notFound().build();

    }
}
