package com.example.apicasadocodigo.cupom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CupomRepository extends JpaRepository<Cupom, Long> {
    public Cupom findByCodigo(String codigo);
}
