package br.com.carlos.casadocodigo.api.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ResponseCupomDto {
    private String codigo;
    private BigDecimal percentualDesconto;
    private LocalDate validade;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getPercentualDesconto() {
        return percentualDesconto;
    }

    public void setPercentualDesconto(BigDecimal percentualDesconto) {
        this.percentualDesconto = percentualDesconto;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }
}
