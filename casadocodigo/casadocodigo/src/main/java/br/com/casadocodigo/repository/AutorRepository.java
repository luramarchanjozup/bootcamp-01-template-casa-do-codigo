package br.com.casadocodigo.repository;

import br.com.casadocodigo.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
