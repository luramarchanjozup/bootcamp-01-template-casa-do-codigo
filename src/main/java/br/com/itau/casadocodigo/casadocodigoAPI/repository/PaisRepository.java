package br.com.itau.casadocodigo.casadocodigoAPI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.itau.casadocodigo.casadocodigoAPI.model.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Integer> {

	Optional<Pais> findByNome(String nome);

}
