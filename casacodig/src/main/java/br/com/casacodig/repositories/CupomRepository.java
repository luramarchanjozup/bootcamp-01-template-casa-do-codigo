package br.com.casacodig.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.casacodig.model.Cupom;

//CupomRepository de Pontos - TOTAL:1
//1 - Cupom

@Repository
public interface CupomRepository extends JpaRepository<Cupom, Long> {

	 Cupom findByCodigo(String codigo);
}
