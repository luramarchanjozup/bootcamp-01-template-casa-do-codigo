package com.casadocodigo.casaDoCodigo.repositories;

import java.util.Optional;

import com.casadocodigo.casaDoCodigo.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long>{
    Optional<Category> findByName(String name);
}
