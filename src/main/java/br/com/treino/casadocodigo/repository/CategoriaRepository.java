package br.com.treino.casadocodigo.repository;

import br.com.treino.casadocodigo.model.Autor;
import br.com.treino.casadocodigo.model.Categoria;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
    public Optional<Categoria> findByNome(String email);
}
