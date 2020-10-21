package br.com.itau.casadocodigo.cadastrocliente.repository;

import br.com.itau.casadocodigo.cadastropaisestado.model.Estado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CadastroEstadoRepository extends CrudRepository<Estado, Long> {

    Optional<Estado> findByEstado(String estado);
}
