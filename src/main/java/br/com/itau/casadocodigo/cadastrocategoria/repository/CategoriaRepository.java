package br.com.itau.casadocodigo.cadastrocategoria.repository;

import br.com.itau.casadocodigo.cadastrocategoria.model.Categoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {

    Optional<Categoria> findByNomeCategoria(String nomeCategoria);
}
