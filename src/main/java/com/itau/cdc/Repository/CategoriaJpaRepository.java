package com.itau.cdc.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itau.cdc.entity.CategoriaEntity;
import com.itau.cdc.model.Categoria;

public interface CategoriaJpaRepository extends JpaRepository<CategoriaEntity, Long> {
	Optional<Categoria> findByNome(String nome);
}
