package br.com.ecommerce.cdc.repository;

import br.com.ecommerce.cdc.domain.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
