package br.com.zup.treinocasadocodigo.repository;

import br.com.zup.treinocasadocodigo.entities.livro.Livro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Contagem de carga intrínseca da classe: 1
 */

@Repository
//1
public interface LivroRepository extends CrudRepository<Livro, Long> {
    List<Livro> findAll();
}
