package com.itau.cdc.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itau.cdc.entity.Categoria;

public interface CategoriaJpaRepository extends JpaRepository<Categoria, Long> {
	Optional<Categoria> findByNome(String nome);
}
