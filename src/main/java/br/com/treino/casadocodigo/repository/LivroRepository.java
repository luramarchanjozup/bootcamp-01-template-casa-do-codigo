package br.com.treino.casadocodigo.repository;

import br.com.treino.casadocodigo.model.Livro;
import org.springframework.data.repository.CrudRepository;

public interface LivroRepository extends CrudRepository<Livro, Long> { //1
}
