package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.response;

import java.math.BigDecimal;

public class ItemCompraResponse {

    private Integer idLivro;
    private BigDecimal valorUnitario;
    private Integer quantidade;

    public ItemCompraResponse(Integer idLivro, BigDecimal valorUnitario, Integer quantidade) {
        this.idLivro = idLivro;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
    }

    public Integer getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Integer idLivro) {
        this.idLivro = idLivro;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
