package br.com.casacodig.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.casacodig.model.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long>{

}
