package br.com.itau.casadocodigo.casadocodigoAPI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.itau.casadocodigo.casadocodigoAPI.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
	
	Optional<Categoria> findByNome(String categoria);

}
