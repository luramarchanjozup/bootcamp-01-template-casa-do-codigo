package br.com.itau.casadocodigo.casadocodigoAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.itau.casadocodigo.casadocodigoAPI.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {

}
