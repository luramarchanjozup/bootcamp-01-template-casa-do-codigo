package br.com.carlos.casadocodigo.domain.repository;

import br.com.carlos.casadocodigo.domain.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository  extends JpaRepository<Livro, Long> {
}
