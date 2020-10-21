package br.com.itau.casadocodigo.cadastrocliente.repository;

import br.com.itau.casadocodigo.cadastrocupom.model.Cupom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CupomRepository extends CrudRepository<Cupom, Long> {

    Optional<Cupom> findByCodigo(String codigoCupom);
}
