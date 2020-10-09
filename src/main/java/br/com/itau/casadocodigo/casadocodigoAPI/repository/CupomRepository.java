package br.com.itau.casadocodigo.casadocodigoAPI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.itau.casadocodigo.casadocodigoAPI.model.Cupom;

public interface CupomRepository extends JpaRepository<Cupom, Integer> {

	Optional<Cupom> findByCodigo(String codigo);

}
