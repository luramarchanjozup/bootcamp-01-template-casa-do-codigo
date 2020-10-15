package br.com.carlos.casadocodigo.api.dto.request;

import br.com.carlos.casadocodigo.domain.entity.Compra;
import br.com.carlos.casadocodigo.domain.entity.ItemPedido;
import br.com.carlos.casadocodigo.domain.entity.Pedido;
import lombok.Getter;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RequestPedidoDto {
    @Positive @NotNull
    private final BigDecimal total;
    @Size(min = 1) @Valid @Getter
    private final List<RequestItensDto> itens;

    public RequestPedidoDto(BigDecimal total, List<RequestItensDto> itens) {
        this.total = total;
        this.itens = itens;
    }

    public Function<Compra, Pedido> toEntity(EntityManager manager) {
        Set<ItemPedido> itensCalculados = itens.stream().map(item -> item.toEntity(manager)).collect(Collectors.toSet());

        return (compra) -> {
            Pedido pedido = new Pedido(compra, itensCalculados);
            Assert.isTrue(pedido.totalIgual(total),"O total enviado não corresponde ao total real");
            return pedido;
        };

    }

}
