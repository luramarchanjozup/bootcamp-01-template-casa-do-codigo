package br.com.zup.treinocasadocodigo.repository;

import br.com.zup.treinocasadocodigo.entities.estado.Estado;
import br.com.zup.treinocasadocodigo.entities.pais.Pais;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Contagem de carga intrínseca da classe: 1
 */

@Repository
//1
public interface EstadoRepository extends CrudRepository<Estado, Long> {
    Optional<Estado> findById(Long id);
    List<Estado> findByPais(Pais pais);
}
