package com.itau.cdc.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.itau.cdc.model.Cupom;

public interface CupomJpaRepository extends CrudRepository<Cupom, Long> {
	Optional<Cupom> findByCodigo(String codigo);
}
