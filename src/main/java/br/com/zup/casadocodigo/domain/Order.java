package br.com.zup.casadocodigo.domain;

import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @NotNull @Valid
    private Buyer buyer;

    @ElementCollection
    @Size(min = 1)
    private Set<OrderItem> orderItem = new HashSet<>();


    @Deprecated
    public Order(){

    }

    public Order(@NotNull @Valid Buyer buyer, @Size(min = 1) Set<OrderItem> orderItem) {
        Assert.isTrue(!orderItem.isEmpty(),
                "each order must have at least one item");
        this.buyer = buyer;
        this.orderItem = orderItem;
    }

    public boolean totalIgual(@Positive @NotNull BigDecimal total) {
        BigDecimal totalOrder = orderItem.stream().map(OrderItem::totalValue).reduce(BigDecimal.ZERO,
                (current, next) -> current.add(next));

        return totalOrder.doubleValue() == total.doubleValue();
    }


    public Set<OrderItem> getOrderItem() {
        return orderItem;
    }
}
