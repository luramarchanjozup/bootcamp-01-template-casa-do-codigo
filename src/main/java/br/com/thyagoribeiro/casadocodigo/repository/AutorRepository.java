package br.com.thyagoribeiro.casadocodigo.repository;

import br.com.thyagoribeiro.casadocodigo.domain.Autor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends CrudRepository<Autor, String> {
}
