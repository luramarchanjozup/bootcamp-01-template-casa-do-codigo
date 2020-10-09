package br.com.itau.casadocodigo.casadocodigoAPI.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.itau.casadocodigo.casadocodigoAPI.model.NovaCompraItensCarrinho;

public interface NovaCompraDetalhesRepository extends JpaRepository<NovaCompraItensCarrinho, Integer> {

	Optional<List<NovaCompraItensCarrinho>> findByNovaCompra_Id(int id);

}
