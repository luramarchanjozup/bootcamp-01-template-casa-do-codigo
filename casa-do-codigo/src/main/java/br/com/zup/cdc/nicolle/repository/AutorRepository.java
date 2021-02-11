package br.com.zup.cdc.nicolle.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.cdc.nicolle.model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long>{
	Optional<Autor> findById(Long Id);
	Optional<Autor> findByNome(String nome);
}
