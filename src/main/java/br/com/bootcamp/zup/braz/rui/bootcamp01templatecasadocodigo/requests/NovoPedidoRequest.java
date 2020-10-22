package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.requests;

import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.Compra;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.ItemCompra;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.Pedido;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NovoPedidoRequest {

    @Positive
    @NotNull
    private BigDecimal total;
    @Size(min = 1)
    @Valid          //1
    private List<NovoPedidoItemRequest> itens = new ArrayList<>();

    @Deprecated
    public NovoPedidoRequest(){

    }

    public NovoPedidoRequest(@Positive @NotNull BigDecimal total, @Size(min = 1) @Valid List<NovoPedidoItemRequest> itens) {
        this.total = total;
        this.itens = itens;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<NovoPedidoItemRequest> getItens() {
        return itens;
    }

    public void setItens(List<NovoPedidoItemRequest> itens) {
        this.itens = itens;
    }

    public Function<Compra, Pedido> toModel(EntityManager entityManager){
        Set<ItemCompra> itensCalculados = itens.stream().map(item -> item.toModel(entityManager)).collect(Collectors.toSet());//2

        return (compra) -> { //2
            Pedido pedido = new Pedido(compra,itensCalculados); //1
            Assert.isTrue(pedido.totalIgual(total), "Total informado difere do total real.");
            return pedido;
        };
    }
}
