package br.com.zup.casadocodigo.repository;

import br.com.zup.casadocodigo.domain.Buyer;
import br.com.zup.casadocodigo.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value = "SELECT SUM(i.price_book * i.quantity) FROM orders p JOIN orders_order_item i WHERE p.id = ?1 AND i.orders_id = ?1",
            nativeQuery = true)
    BigDecimal totalBuy(Long id);
}
