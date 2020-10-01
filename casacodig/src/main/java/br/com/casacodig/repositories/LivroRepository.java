package br.com.casacodig.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.casacodig.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{
	Livro findByNome(String nome);
}
