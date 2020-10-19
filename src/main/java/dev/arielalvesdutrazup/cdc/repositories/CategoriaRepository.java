package dev.arielalvesdutrazup.cdc.repositories;

import dev.arielalvesdutrazup.cdc.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Optional<Categoria> findByNome(String nome);
}
