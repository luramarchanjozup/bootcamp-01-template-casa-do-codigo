package br.com.treino.casadocodigo.repository;

import br.com.treino.casadocodigo.model.Livro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Long> { //1
}
