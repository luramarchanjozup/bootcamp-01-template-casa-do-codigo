package br.com.treino.casadocodigo.repository;

import br.com.treino.casadocodigo.model.Autor;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AutorRepository extends CrudRepository<Autor, Long> {

    public Optional<Autor> findByEmail(String email);

}
