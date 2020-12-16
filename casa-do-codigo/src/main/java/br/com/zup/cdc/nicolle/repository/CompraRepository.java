package br.com.zup.cdc.nicolle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.cdc.nicolle.model.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long>{
	

}
