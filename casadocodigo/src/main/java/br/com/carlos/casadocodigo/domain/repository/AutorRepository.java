package br.com.carlos.casadocodigo.domain.repository;

import br.com.carlos.casadocodigo.domain.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    Optional<Autor> findByEmail(String email);
}
