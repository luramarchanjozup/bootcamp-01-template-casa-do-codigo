package com.itau.cdc.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itau.cdc.entity.AutorEntity;
import com.itau.cdc.model.Autor;

public interface AutorJpaRepository extends JpaRepository<AutorEntity, Long>{
	Optional<Autor> findByEmail(String email);
}
