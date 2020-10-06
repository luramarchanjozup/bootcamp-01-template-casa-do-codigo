package com.itau.cdc.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.itau.cdc.entity.Livro;

public interface LivroJpaRepository extends CrudRepository<Livro, Long> {
	Optional<Livro> findByTitulo(String titulo);
}
