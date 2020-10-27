package com.casaDoCodigo.Nicolle.Estado;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends CrudRepository<Estado, Long> {

	Optional<Estado> findByEstado(String estado);

	Optional<Estado> findByPaisId(String paisNome);

}
