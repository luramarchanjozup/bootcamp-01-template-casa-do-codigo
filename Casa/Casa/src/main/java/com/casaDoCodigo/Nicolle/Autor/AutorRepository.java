package com.casaDoCodigo.Nicolle.Autor;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AutorRepository extends CrudRepository<Autor, Long>{
	Optional<Autor> findById(Long Id);
	Optional<Autor> findByNome(String nome);
}
