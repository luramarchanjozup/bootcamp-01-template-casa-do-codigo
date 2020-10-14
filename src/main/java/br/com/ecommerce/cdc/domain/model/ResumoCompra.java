package br.com.ecommerce.cdc.domain.model;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * Carga intrínseca máxima permitida - 9
 * Carga intrínseca da classe - 4
 */

public class ResumoCompra {

    private BigDecimal valorTotal;
    private BigDecimal desconto;
    private BigDecimal valorPagar;

    public ResumoCompra() {
    }

    public ResumoCompra(BigDecimal valorTotal, BigDecimal desconto, BigDecimal valorPagar) {
        this.valorTotal = valorTotal;
        this.desconto = desconto;
        this.valorPagar = valorPagar;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public BigDecimal getValorPagar() {
        return valorPagar;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public void setValorPagar(BigDecimal valorPagar) {
        this.valorPagar = valorPagar;
    }

    // +2 (Cupom Desconto, CarrinhoCompra)
    public ResumoCompra finalizandoCompra(Optional<CupomDesconto> cupomDesconto, CarrinhoCompra carrinhoCompra){
        // +1
        if(cupomDesconto.isPresent()){
            var desconto = carrinhoCompra.getTotal().multiply(cupomDesconto.get().desconto());
            this.valorPagar = carrinhoCompra.getTotal().subtract(desconto).setScale(2);
            this.valorTotal = carrinhoCompra.getTotal().setScale(2);
            this.desconto = desconto.setScale(2);

         // +1
        }else{
            this.valorTotal = carrinhoCompra.getTotal().setScale(2);
            this.desconto = new BigDecimal(0).setScale(2);
            this.valorPagar = carrinhoCompra.getTotal().setScale(2);
        }
        return this;
    }
}
