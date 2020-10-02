package br.com.carlos.casadocodigo.domain.repository;

import br.com.carlos.casadocodigo.domain.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
