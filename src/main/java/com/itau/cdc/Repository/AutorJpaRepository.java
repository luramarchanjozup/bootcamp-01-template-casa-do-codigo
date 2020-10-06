package com.itau.cdc.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itau.cdc.entity.Autor;

public interface AutorJpaRepository extends JpaRepository<Autor, Long>{
	Optional<Autor> findByEmail(String email);

	Optional<Autor> findById(Long id);
}
