package com.itau.cdc.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.itau.cdc.entity.Cupom2;

public interface CupomJpaRepository extends CrudRepository<Cupom2, Long> {
	Optional<Cupom2> findByCodigo(String codigoCupom);
}
