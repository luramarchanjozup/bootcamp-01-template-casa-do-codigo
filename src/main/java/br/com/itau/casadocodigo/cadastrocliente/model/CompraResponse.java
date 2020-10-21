package br.com.itau.casadocodigo.cadastrocliente.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class CompraResponse {

    private final BigDecimal total;
    private final BigDecimal totalComDesconto;
    private final List<ItensResponse> itens;

    public BigDecimal getTotal() {
        return total;
    }

    public BigDecimal getTotalComDesconto() {
        return totalComDesconto;
    }

    public List<ItensResponse> getItens() {
        return itens;
    }

    public CompraResponse(Compra compra) { //1 1
        this.total = compra.getTotal();
        this.totalComDesconto = compra.getTotalComDesconto();
        this.itens = compra.getItens().stream().map(item -> new ItensResponse(item.getIdLivro(), item.getQuantidade()))
                .collect(Collectors.toList());
    }
}
