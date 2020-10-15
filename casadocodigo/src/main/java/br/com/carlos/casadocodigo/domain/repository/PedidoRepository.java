package br.com.carlos.casadocodigo.domain.repository;

import br.com.carlos.casadocodigo.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    @Query(value = "SELECT SUM(i.preco_momento * i.quantidade) FROM pedidos p JOIN pedido_itens i WHERE p.id = ?1 AND i.pedido_id = ?1",
            nativeQuery = true)
    BigDecimal valorTotalPedido(Long id);
}
