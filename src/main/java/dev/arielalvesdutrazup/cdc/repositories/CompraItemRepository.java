package dev.arielalvesdutrazup.cdc.repositories;

import dev.arielalvesdutrazup.cdc.entities.CompraItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompraItemRepository extends JpaRepository<CompraItem, Long>  {
    List<CompraItem> findAllByCompraId(Long id);
}
