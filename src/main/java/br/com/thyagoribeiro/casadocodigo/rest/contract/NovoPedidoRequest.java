package br.com.thyagoribeiro.casadocodigo.rest.contract;

import br.com.thyagoribeiro.casadocodigo.domain.Item;
import br.com.thyagoribeiro.casadocodigo.domain.Pedido;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class NovoPedidoRequest {

    @NotNull
    @Positive
    private BigDecimal total;

    @NotNull
    @Size(min = 1)
    @Valid
    private List<NovoItemRequest> itens;

    @Deprecated
    public NovoPedidoRequest() {
    }

    public NovoPedidoRequest(@NotNull @Positive BigDecimal total, @Size(min = 1) List<NovoItemRequest> itens) {
        this.total = total;
        this.itens = itens;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<NovoItemRequest> getItens() {
        return itens;
    }

    public void setItens(List<NovoItemRequest> itens) {
        this.itens = itens;
    }

    public Pedido toModel(){
        List<Item> itemList = new ArrayList<>();
        itens.forEach(item -> itemList.add(item.toModel()));
        return new Pedido(itemList);
    }
}
