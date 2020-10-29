package bootcamp.challenges.casadocodigo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.OneToMany;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Set;

@Embeddable
public class Order {
    @NotNull
    @DecimalMin("20.00")
    @Digits(integer=6, fraction=2)
    @Column(nullable = false)
    private BigDecimal total;
    @NotEmpty
    @OneToMany(mappedBy = "billing", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Item> items;

    @Deprecated
    public Order() {}

    public Order(BigDecimal total, Set<Item> items) {
        this.total = total;
        this.items = items;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public Set<Item> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Order{" +
                ", total=" + total +
                ", items=" + items +
                '}';
    }
}
