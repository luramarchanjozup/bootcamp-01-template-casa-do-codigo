package com.casadocodigo.casaDoCodigo.repositories;

import com.casadocodigo.casaDoCodigo.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    
}
