package com.casadocodigo.repository;

import org.springframework.data.repository.CrudRepository;

import com.casadocodigo.entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {
	
}
