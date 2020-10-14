package br.com.ecommerce.cdc.repository;

import br.com.ecommerce.cdc.domain.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    Optional<Categoria> findByNome(String nome);
}
