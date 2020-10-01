package com.github.marcoscoutozup.casadocodigo.fluxocompra.cupom;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CupomRepository extends JpaRepository<Cupom, UUID> {

    Optional<Cupom> findByCodigo(String codigo);

}
