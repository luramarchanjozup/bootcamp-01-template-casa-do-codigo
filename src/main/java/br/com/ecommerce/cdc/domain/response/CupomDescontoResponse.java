package br.com.ecommerce.cdc.domain.response;

import br.com.ecommerce.cdc.domain.model.CupomDesconto;

import java.time.LocalDate;

/**
 * Carga Intrínseca máxima permitida - 9
 * Carga Intrínseca da classe - 1
 * */

public class CupomDescontoResponse {

    private Long id;
    private String codigo;
    private Double desconto;
    private LocalDate validade;

    public CupomDescontoResponse() {
    }

    public CupomDescontoResponse(Long id, String codigo, Double desconto, LocalDate validade) {
        this.id = id;
        this.codigo = codigo;
        this.desconto = desconto;
        this.validade = validade;
    }
    // +1
    public CupomDescontoResponse(CupomDesconto cupomDesconto){
        this.id = cupomDesconto.getId();
        this.codigo = cupomDesconto.getCodigo();
        this.desconto = cupomDesconto.getDesconto();
        this.validade = cupomDesconto.getValidade();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }
}
