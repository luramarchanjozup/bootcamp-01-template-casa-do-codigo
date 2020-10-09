package br.com.ecommerce.cdc.repository;

import br.com.ecommerce.cdc.domain.model.CupomDesconto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CupomDescontoRepository extends JpaRepository<CupomDesconto, Long> {

    Optional<CupomDesconto> findByCodigo(String codigo);

}
