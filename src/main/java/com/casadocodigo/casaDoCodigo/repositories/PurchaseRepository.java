package com.casadocodigo.casaDoCodigo.repositories;

import com.casadocodigo.casaDoCodigo.model.Purchases;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchases, Long> {
    
}
