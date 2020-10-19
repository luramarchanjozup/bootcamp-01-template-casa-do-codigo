package br.com.casacodig.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.casacodig.model.Categoria;


//Contagem de Pontos - TOTAL:1
//1 - Categoria

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	Categoria findByNome(String nome);
}
