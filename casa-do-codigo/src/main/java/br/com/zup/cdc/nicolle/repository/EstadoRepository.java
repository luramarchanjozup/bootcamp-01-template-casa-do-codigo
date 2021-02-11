package br.com.zup.cdc.nicolle.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.cdc.nicolle.model.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
	Optional<Estado> findByEstado(String estado);
	Optional<Estado> findByPaisId(String paisNome);
}
