package br.com.zup.treinocasadocodigo.repository;

import br.com.zup.treinocasadocodigo.entities.categoria.Categoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Contagem de carga intrínseca da classe: 1
 */

@Repository
//1
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {

    Optional<Categoria> findByNome(String nome);

}
