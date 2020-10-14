package br.com.zup.casadocodigo.dto;

import br.com.zup.casadocodigo.domain.Buyer;
import br.com.zup.casadocodigo.domain.Order;
import br.com.zup.casadocodigo.domain.OrderItem;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OrderDTO {

    @Positive @NotNull
    private BigDecimal total;

    @Size(min = 1) @Valid
    private List<OrderItemDTO> orderItem;


    public OrderDTO(@Positive @NotNull BigDecimal total, @Size(min = 1) @Valid List<OrderItemDTO> orderItem) {
        this.total = total;
        this.orderItem = orderItem;
    }

    public List<OrderItemDTO> getItem(){
        return orderItem;
    }

    public Function<Buyer, Order> toModel(EntityManager manager) {

        Set<OrderItem> calculatedItems = orderItem.stream().map(item -> item.toModel(manager)).collect(Collectors.toSet());

        return (buy) -> {
            Order order = new Order(buy,calculatedItems);
            Assert.isTrue(order.totalIgual(total),"the total sent does not correspond to the actual total");
            return order;
        };

    }
}
