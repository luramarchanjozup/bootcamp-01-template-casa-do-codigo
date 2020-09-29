package br.com.casadocodigo.repositories;

import br.com.casadocodigo.models.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingRepository extends JpaRepository<ShoppingCart, Long> {

}
