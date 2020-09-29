package com.casadocodigo.cadaDoCodigo.repositories;

import java.util.Optional;

import com.casadocodigo.cadaDoCodigo.model.Author;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepositiory extends JpaRepository<Author, Long> {
    Optional<Author> findByEmail(String email);
}
