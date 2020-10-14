package br.com.zup.treinocasadocodigo.entities.compra;

import br.com.zup.treinocasadocodigo.entities.compra.itemcompra.ItemCompraNovoRequest;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.List;

/**
 * Contagem de carga intrínseca da classe: 1
 */

public class PedidoCompraNovoRequest {

    @Positive
    @NotNull
    private BigDecimal total;

    @NotEmpty
    @Valid
    //1
    List<ItemCompraNovoRequest> itens;

    private String codigoCupom;

    public BigDecimal getTotal() {
        return total;
    }

    public List<ItemCompraNovoRequest> getItens() {
        return itens;
    }

    public String getCodigoCupom() {
        return codigoCupom;
    }

    @Override
    public String toString() {
        return "PedidoCompraRequest{" +
                "total=" + total +
                ", itens=" + itens +
                ", codigoCupom='" + codigoCupom + '\'' +
                '}';
    }
}
