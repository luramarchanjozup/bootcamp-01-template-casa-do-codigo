package com.casadocodigo.casaDoCodigo.repositories;

import com.casadocodigo.casaDoCodigo.model.Cart;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
    
}
