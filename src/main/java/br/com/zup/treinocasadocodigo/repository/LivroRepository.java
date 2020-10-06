package br.com.zup.treinocasadocodigo.repository;

import br.com.zup.treinocasadocodigo.entities.Livro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Long> {
    List<Livro> findAll();
}
