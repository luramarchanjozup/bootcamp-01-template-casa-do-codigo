package br.com.zup.treinocasadocodigo.repository;

import br.com.zup.treinocasadocodigo.entities.Autor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Contagem de carga intrínseca da classe: 0
 */

@Repository
public interface AutorRepository extends CrudRepository<Autor, Long> {

    Optional<Autor> findByEmail(String email);

}
