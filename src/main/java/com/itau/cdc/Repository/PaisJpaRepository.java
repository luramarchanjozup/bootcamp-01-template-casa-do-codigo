package com.itau.cdc.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itau.cdc.model.Pais;

public interface PaisJpaRepository extends JpaRepository<Pais, Long> {

	Optional<Pais> findByNome(String nome);

}
