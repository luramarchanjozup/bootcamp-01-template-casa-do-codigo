package br.com.zup.treinocasadocodigo.repository;

import br.com.zup.treinocasadocodigo.entities.compra.itemcompra.ItemCompra;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Contagem de carga intrínseca da classe: 1
 */

@Repository
//1
public interface ItemCompraRepository extends CrudRepository<ItemCompra, Long> {
    @Query("FROM ItemCompra WHERE compra_id = :compra_id")
    List<ItemCompra> findByCompraId(@Param("compra_id") Long compra_id);
}
