package br.com.casadocodigo.repository;

import br.com.casadocodigo.model.Cupom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CupomRepository extends JpaRepository<Cupom, Long> {
    public Cupom getByCodigo(String codigo);
}
