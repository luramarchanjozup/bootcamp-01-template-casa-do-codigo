package br.com.zup.treinocasadocodigo.repository;

import br.com.zup.treinocasadocodigo.entities.cupom.Cupom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Contagem de carga intrínseca da classe: 1
 */

@Repository
//1
public interface CupomRepository extends CrudRepository<Cupom, Long> {
    List<Cupom> findByCodigo(String codigo);
}
