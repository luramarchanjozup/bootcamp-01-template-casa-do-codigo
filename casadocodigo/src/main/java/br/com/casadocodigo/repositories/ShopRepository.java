package br.com.casadocodigo.repositories;

import br.com.casadocodigo.models.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends CrudRepository<UserData, Long> {

}
