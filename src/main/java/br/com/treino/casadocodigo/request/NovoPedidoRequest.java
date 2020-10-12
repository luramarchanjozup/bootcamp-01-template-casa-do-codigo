package br.com.treino.casadocodigo.request;

import br.com.treino.casadocodigo.model.ItemPedido;
import br.com.treino.casadocodigo.model.Pedido;
import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NovoPedidoRequest {

    @NotNull @Size(min = 1)
    private List<NovoItemPedidoRequest> itemPedidos = new ArrayList<>(); //1

    @Deprecated
    public NovoPedidoRequest(){}

    public NovoPedidoRequest(@NotNull @Size(min = 1) List<NovoItemPedidoRequest> itemPedidos) {
        this.itemPedidos = itemPedidos;
    }

    public List<NovoItemPedidoRequest> getItemPedidos() {
        return itemPedidos;
    }

    public Pedido toModel(EntityManager entityManager){ //2

        /*Set<ItemPedido> itemCauculados = itemPedidos.stream().map(item ->
                item.toModel(entityManager))
                .collect(Collectors.toSet());*/

        Set<ItemPedido> itemCauculados = new HashSet<>();

        for (NovoItemPedidoRequest item : itemPedidos) { //3
            ItemPedido itemPedido = item.toModel(entityManager); //4

            itemCauculados.add(itemPedido);
        }

        Pedido pedido = new Pedido(itemCauculados);
        pedido.calcularTotalPedido();

        return pedido;
    }


}
