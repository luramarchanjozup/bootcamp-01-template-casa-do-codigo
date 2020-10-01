package com.casadocodigo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.casadocodigo.entity.Categories;

public interface CategoriesRepository extends CrudRepository<Categories, Integer> {
	
	Optional<Categories> findByName(String name);
}
