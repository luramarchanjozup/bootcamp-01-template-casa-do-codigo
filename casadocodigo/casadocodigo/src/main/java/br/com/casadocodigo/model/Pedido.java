package br.com.casadocodigo.model;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Valid
    @OneToOne
    private Compra compra;

    @ElementCollection
    private @Size(min = 1) Set<ItemPedido> itens = new HashSet<>();

    public Pedido(@NotNull @Valid Compra compra,
                  @Size(min = 1) Set<ItemPedido> itens) {

        this.compra = compra;
        this.itens.addAll(itens);
    }

    public boolean totalIgual(@Positive @NotNull BigDecimal total) {
        BigDecimal totalPedido = itens.stream().map(ItemPedido::total).reduce(BigDecimal.ZERO,
                (atual, proximo) -> atual.add(proximo));

        return totalPedido.doubleValue() == total.doubleValue();
    }

    @Override
    public String toString() {
        return "Pedido [itens=" + itens + "]";
    }

}
