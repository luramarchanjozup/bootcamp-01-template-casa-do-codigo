package br.com.casacodig.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.casacodig.model.Livro;

//Contagem de Pontos - TOTAL:3
//1 - Livro

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{
	Livro findByTitulo(String titulo);
}
