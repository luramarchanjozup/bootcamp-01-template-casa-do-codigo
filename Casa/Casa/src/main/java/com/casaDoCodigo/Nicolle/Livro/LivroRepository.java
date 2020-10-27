package com.casaDoCodigo.Nicolle.Livro;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Long> {
	
	
	
	@Override
	Collection<Livro> findAll();

}
