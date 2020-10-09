package br.com.casacodig.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.casacodig.model.Cupom;



@Repository
public interface CupomRepository extends JpaRepository<Cupom, Long> {

	 Cupom findByCodigo(String codigo);
}
