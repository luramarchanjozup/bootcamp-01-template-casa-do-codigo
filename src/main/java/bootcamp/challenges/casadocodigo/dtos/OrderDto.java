package bootcamp.challenges.casadocodigo.dtos;

import bootcamp.challenges.casadocodigo.entities.Item;
import bootcamp.challenges.casadocodigo.entities.Order;
import org.springframework.validation.annotation.Validated;

import javax.persistence.EntityManager;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

// Total Intrinsic Load Points: 2
@Validated
public final class OrderDto {
    @Positive
    @NotNull
    @Digits(integer=6, fraction=2)
    private final BigDecimal total;
    @NotEmpty
    private final Set<ItemDto> itemsDto;

    public OrderDto(@NotNull @Positive BigDecimal total, @NotNull Set<ItemDto> itemsDto) {
        this.total = total;
        this.itemsDto = itemsDto;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public Set<ItemDto> getItems() {
        return itemsDto;
    }

    public Order toModel(EntityManager entityManager){
        @NotNull Set<Item> items = itemsDto.stream().map( itemDto -> itemDto.toModel(entityManager)).collect(Collectors.toSet());

        if (!items.isEmpty()) return new Order(total, items);
        return null;
    }
}
