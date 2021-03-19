package br.com.casadocodigo.repositories;

import br.com.casadocodigo.models.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends CrudRepository<State, Long> {

    State findByName(String name);

}
