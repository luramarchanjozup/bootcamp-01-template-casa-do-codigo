package br.com.ecommerce.cdc.repository;

import br.com.ecommerce.cdc.domain.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraRepository extends JpaRepository<Compra, Long> {

}
