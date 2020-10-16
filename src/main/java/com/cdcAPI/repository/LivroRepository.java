package com.cdcAPI.repository;

import com.cdcAPI.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LivroRepository extends JpaRepository<Livro, String> {

    Optional<Livro> findById(Long id);
}
