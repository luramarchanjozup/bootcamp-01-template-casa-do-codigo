package com.casadocodigo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.casadocodigo.entity.Author;

public interface AuthorRepository extends CrudRepository<Author, Integer> {
	
	Optional<Author> findByEmail(String email);
}
