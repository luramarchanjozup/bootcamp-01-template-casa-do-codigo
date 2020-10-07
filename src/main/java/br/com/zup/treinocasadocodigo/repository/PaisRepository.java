package br.com.zup.treinocasadocodigo.repository;

import br.com.zup.treinocasadocodigo.entities.pais.Pais;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaisRepository extends CrudRepository<Pais, Long> {
    Optional<Pais> findById(Long id);
}
