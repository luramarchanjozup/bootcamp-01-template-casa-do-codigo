package com.casaDoCodigo.Nicolle.Cupom;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CupomRepository extends CrudRepository<Cupom, Long> {
	

	Optional<Cupom> findByCodigo(String codigoCupom);

}
