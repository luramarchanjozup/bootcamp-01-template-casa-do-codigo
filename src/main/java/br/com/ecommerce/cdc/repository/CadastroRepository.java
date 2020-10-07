package br.com.ecommerce.cdc.repository;

import br.com.ecommerce.cdc.domain.model.Cadastro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CadastroRepository extends JpaRepository<Cadastro, Long> {

}
