package br.com.carlos.casadocodigo.domain.repository;

import br.com.carlos.casadocodigo.domain.entity.Cupom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CupomRepository extends JpaRepository<Cupom,Long> {
    Optional<Cupom> getByCodigo(String codigo);
}
