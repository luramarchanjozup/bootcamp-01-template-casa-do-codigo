package br.com.zup.cdc.nicolle.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.cdc.nicolle.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{
	
	Page<Livro> findByTitulo(String titulo, Pageable paginacao);
}
