package com.casadocodigo.casaDoCodigo.repositories;

import com.casadocodigo.casaDoCodigo.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long>{
    
}
