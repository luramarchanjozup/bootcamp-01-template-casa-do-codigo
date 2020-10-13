package com.example.apicasadocodigo.fluxocompra.compra;

import com.example.apicasadocodigo.fluxocompra.compra.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {
}