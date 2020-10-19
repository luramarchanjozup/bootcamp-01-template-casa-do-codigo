package br.com.casacodig.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.casacodig.model.Estado;

//Contagem de Pontos - TOTAL:1
//1 - Estado

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long>{

}
