package com.itau.cdc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itau.cdc.entity.Estado;

import java.util.Optional;

public interface EstadoJpaRepository extends JpaRepository<Estado, Long> {

	Optional<Estado> findByNome(String nome);

}
