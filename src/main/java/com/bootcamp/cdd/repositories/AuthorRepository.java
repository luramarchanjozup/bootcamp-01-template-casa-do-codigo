package com.bootcamp.cdd.repositories;

import com.bootcamp.cdd.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findByEmail (String email);
}
