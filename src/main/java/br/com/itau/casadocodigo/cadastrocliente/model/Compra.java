package br.com.itau.casadocodigo.cadastrocliente.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Entity
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Positive
    private BigDecimal total;
    private BigDecimal totalComDesconto;
    @NotNull
    @Size(min = 1)
    @ElementCollection
    private List<Itens> itens;
    @OneToOne
    @JoinColumn(name = "id")
    private Cliente cliente;

    @Deprecated
    public Compra() {
    }

    public Compra(@NotNull @Positive BigDecimal total, BigDecimal totalComDesconto, @NotNull @Size(min = 1) List<Itens> itens) {
        this.total = total;
        this.totalComDesconto = totalComDesconto;
        this.itens = itens;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getTotalComDesconto() {
        return totalComDesconto;
    }

    public void setTotalComDesconto(BigDecimal totalComDesconto) {
        this.totalComDesconto = totalComDesconto;
    }

    public List<Itens> getItens() {
        return itens;
    }

    public void setItens(List<Itens> itens) {
        this.itens = itens;
    }
//1
    public void aplicaDesconto(CupomDesconto cupomDesconto) {
        BigDecimal percentualDesconto = cupomDesconto.getPercentualDesconto();
        BigDecimal valorDoPercentual = percentualDesconto.divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_DOWN);
        BigDecimal valorDoDesconto = this.total.multiply(valorDoPercentual).setScale(2, RoundingMode.HALF_DOWN);
        this.totalComDesconto = this.total.subtract(valorDoDesconto);
    }
}
