package br.com.zup.casadocodigo.repository;

import br.com.zup.casadocodigo.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String email);
}
