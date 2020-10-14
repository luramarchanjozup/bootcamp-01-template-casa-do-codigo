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

// CDD - Total 3

public class NovoPedidoRequest {

    @NotNull
    @Positive
    private BigDecimal total;

    @NotNull
    @Size(min = 1)
    @Valid
    private List<NovoItemRequest> novoItemRequestList; // CDD 1 - Classe NovoItemRequest

    @Deprecated
    public NovoPedidoRequest() {
    }

    public NovoPedidoRequest(@NotNull @Positive BigDecimal total, @Size(min = 1) @Valid List<NovoItemRequest> itens) {
        this.total = total;
        this.novoItemRequestList = itens;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<NovoItemRequest> getNovoItemRequestList() {
        return novoItemRequestList;
    }

    public void setNovoItemRequestList(List<NovoItemRequest> novoItemRequestList) {
        this.novoItemRequestList = novoItemRequestList;
    }

    public Pedido toModel() { // CDD 1 - Classe Pedido
        List<Item> itemList = new ArrayList<>(); // CDD 1 - Classe Item
        novoItemRequestList.forEach(novoItemRequest -> itemList.add(novoItemRequest.toModel()));
        return new Pedido(total, itemList);
    }
}
