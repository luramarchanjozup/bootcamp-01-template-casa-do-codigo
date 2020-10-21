package br.com.itau.casadocodigo.cadastrocliente.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class CompraRequest {

    @NotNull
    @Positive
    private final BigDecimal total;
    @NotNull
    @Size(min = 1)
    private final List<ItensRequest> itens;

    public CompraRequest(@NotNull @Positive BigDecimal total, @NotNull List<ItensRequest> itens) {
        this.total = total;
        this.itens = itens;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public List<ItensRequest> getItens() {
        return itens;
    }

    public Compra toCompraModel(CupomDesconto cupomDesconto) { //1
        BigDecimal totalComDesconto = new BigDecimal(0);

        Compra compra = new Compra(this.total, totalComDesconto , this.itens.stream()
                .map(item -> new ItensRequest(item.getIdLivro(), item.getQuantidade()).toItensModel()) //1
                .collect(Collectors.toList()));

        if (cupomDesconto != null) { //1
            compra.aplicaDesconto(cupomDesconto);
        }
        return compra;
    }

    public boolean valorTotalEhValido(BigDecimal valorTotalDB) {
        return this.total.equals(valorTotalDB);
    }

    public int quantidadeTotalDeLivros() {
        return this.itens.size();
    }
}
