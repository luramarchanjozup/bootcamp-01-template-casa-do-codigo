package br.com.casacodig.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.casacodig.model.Autor;
import br.com.casacodig.model.Categoria;


//Contagem de Pontos - TOTAL:0

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	Autor findByNome(String nome);
}
