package dev.arielalvesdutrazup.cdc.repositories;

import dev.arielalvesdutrazup.cdc.entities.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CompraRepository extends JpaRepository<Compra, Long> {

    @Query("SELECT c FROM Compra c JOIN FETCH c.itens WHERE c.id = :id")
    Optional<Compra> findFetchById(Long id);
}
