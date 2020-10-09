package br.com.itau.casadocodigo.casadocodigoAPI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.itau.casadocodigo.casadocodigoAPI.model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer> {

	Optional<Autor> findByEmail(String email);
	Optional<Autor> findByNome(String nome);

}
