package br.com.zup.treinocasadocodigo.entities.compra;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.List;

/**
 * Contagem de carga intrínseca da classe: 1
 */

public class PedidoCompraRequest {

    @Positive
    @NotNull
    private BigDecimal total;

    @NotEmpty
    @Valid
    //1
    List<ItensCompraRequest> itens;

    public PedidoCompraRequest(@Positive @NotNull BigDecimal total, @NotEmpty @Valid List<ItensCompraRequest> itens) {
        this.total = total;
        this.itens = itens;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public List<ItensCompraRequest> getItens() {
        return itens;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "total=" + total +
                ", itens=" + itens +
                '}';
    }
}
