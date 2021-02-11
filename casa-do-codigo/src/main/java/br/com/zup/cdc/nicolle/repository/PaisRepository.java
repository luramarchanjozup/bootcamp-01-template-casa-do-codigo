package br.com.zup.cdc.nicolle.repository;

import java.util.Optional;

import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.cdc.nicolle.model.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long>{


	
	Optional<Pais> findById(Long id);
	Optional<Pais> findByPais(@NotBlank String pais);
	
	
	

}
