package br.com.zup.treinocasadocodigo.entities.compra;

import br.com.zup.treinocasadocodigo.entities.compra.itemcompra.ItemCompraRequest;

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
    List<ItemCompraRequest> itens;

    public PedidoCompraRequest(@Positive @NotNull BigDecimal total, @NotEmpty @Valid List<ItemCompraRequest> itens) {
        this.total = total;
        this.itens = itens;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public List<ItemCompraRequest> getItens() {
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
