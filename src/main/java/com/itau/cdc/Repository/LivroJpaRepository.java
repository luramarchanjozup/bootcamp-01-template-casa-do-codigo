package com.itau.cdc.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.itau.cdc.model.Livro2;

public interface LivroJpaRepository extends CrudRepository<Livro2, Long> {
	Optional<Livro2> findByTitulo(String titulo);
}
