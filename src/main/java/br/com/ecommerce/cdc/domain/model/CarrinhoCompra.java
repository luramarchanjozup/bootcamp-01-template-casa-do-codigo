package br.com.ecommerce.cdc.domain.model;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;
/**
 * Carga Intrínseca máxima permitida - 9
 * Carga Intrínseca da classe - 2
 *
 */

@Entity
@Table(name = "carrinhoCompra")
public class CarrinhoCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Positive
    private BigDecimal total;

    @OneToOne
    // +1
    private Compra compra;
    @NotNull
    @ElementCollection
    @Size(min = 1 ,message = " tem que tem pelo menos 1 item")
    // +1
    private Set< @Valid ItensPedido> itens;

    public CarrinhoCompra() {
    }

    public CarrinhoCompra(@NotNull @Positive @DecimalMax(value = "2") BigDecimal total, @NotNull @Size(min = 1, message = " tem que tem pelo menos 1 item") Set<@Valid ItensPedido> itens) {
        this.total = total;
        this.itens = itens;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Set<ItensPedido> getItens() {
        return itens;
    }

    public void setItens(Set<ItensPedido> itens) {
        this.itens = itens;
    }

    @Override
    public String toString() {
        return "CarrinhoCompra{" +
                "id=" + id +
                ", total=" + total +
                ", compra=" + compra +
                ", itens=" + itens +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarrinhoCompra that = (CarrinhoCompra) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
