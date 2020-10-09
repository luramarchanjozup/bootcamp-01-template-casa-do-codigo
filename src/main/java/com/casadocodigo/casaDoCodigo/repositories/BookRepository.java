package com.casadocodigo.casaDoCodigo.repositories;

import java.util.Optional;

import com.casadocodigo.casaDoCodigo.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByTitle(String title);
    Optional<Book> findByIsbn(String isbn);
}
