package com.casaDoCodigo.Nicolle.Pais;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends CrudRepository<Pais, Long> {

	Optional<Pais> findByPais(String pais);
	Optional<Pais> findById(Long id);

}
