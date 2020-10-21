package br.com.itau.casadocodigo.cadastrocliente.repository;

import br.com.itau.casadocodigo.cadastropaisestado.model.Pais;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CadastroPaisRepository extends CrudRepository<Pais, Long> {

    Optional<Pais> findByPais(String pais);
}
