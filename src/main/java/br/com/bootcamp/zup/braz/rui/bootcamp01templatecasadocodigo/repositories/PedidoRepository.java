package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.repositories;

import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
