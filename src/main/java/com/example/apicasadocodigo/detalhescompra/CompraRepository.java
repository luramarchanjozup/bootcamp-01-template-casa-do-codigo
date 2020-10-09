package com.example.apicasadocodigo.detalhescompra;

import com.example.apicasadocodigo.compra.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {
}