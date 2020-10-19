package dev.arielalvesdutrazup.cdc.repositories;

import dev.arielalvesdutrazup.cdc.entities.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    Optional<Livro> findByTituloOrIsbn(String titulo, String isbn);

    boolean existsByTituloOrIsbn(String titulo, String isbn);

    boolean existsByTitulo(String titulo);

    boolean existsByIsbn(String isbn);
}
