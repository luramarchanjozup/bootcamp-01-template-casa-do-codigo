package br.com.casacodig.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.casacodig.model.Autor;

//Contagem de Pontos - TOTAL:0

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
	
	Autor findByEmail(String email);

}
