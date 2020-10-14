package br.com.ecommerce.cdc.repository;

import br.com.ecommerce.cdc.domain.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

    Optional<Estado> findByIdAndPaisId(Long estadoId, Long paisId);
}
