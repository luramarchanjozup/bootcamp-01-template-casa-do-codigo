package br.com.ecommerce.cdc.domain.request;

import br.com.ecommerce.cdc.domain.model.CarrinhoCompra;
import br.com.ecommerce.cdc.domain.model.ItensPedido;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Carga Intrínseca máxima permitida - 9
 * Carga Intrínseca da classe - 4
 *
 */

public class CarrinhoCompraRequest {

    @NotNull
    @Positive
    private BigDecimal total;
    @NotNull
    @Size(min = 1 ,message = " tem que tem pelo menos 1 item")
    // +1
    private Set< @Valid ItensRequest> itens = new HashSet<>();

    public CarrinhoCompraRequest() {
    }

    public CarrinhoCompraRequest(@NotNull @NotEmpty @Positive BigDecimal total, @NotNull Set<ItensRequest> itens) {
        this.total = total;
        this.itens = itens;
    }
    // +1
    public CarrinhoCompra toModel(EntityManager manager){
        // +1
        Set<ItensPedido> itensPedidos = toSetModel(manager);
        return new CarrinhoCompra(total,itensPedidos);
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Set<ItensRequest> getItens() {
        return itens;
    }

    public void setItens(Set<ItensRequest> itens) {
        this.itens = itens;
    }

    @Override
    public String toString() {
        return "CarrinhoCompraRequest{" +
                "total=" + total +
                ", itens=" + itens +
                '}';
    }

    private Set<ItensPedido> toSetModel(EntityManager manager){
        // +1
        return itens.stream().map(itensRequest -> {
            return itensRequest.toModel(manager);
        }).collect(Collectors.toSet());
    }
}
