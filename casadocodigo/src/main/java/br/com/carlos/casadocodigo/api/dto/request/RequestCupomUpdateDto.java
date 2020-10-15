package br.com.carlos.casadocodigo.api.dto.request;

import br.com.carlos.casadocodigo.api.handler.Unique;
import br.com.carlos.casadocodigo.domain.entity.Cupom;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.time.LocalDate;

public class RequestCupomUpdateDto {
    @Unique(domainClass = Cupom.class, fieldName = "codigo")
    private String codigo;
    @Min(20)
    private BigDecimal percentualDesconto;
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate validade;

    public RequestCupomUpdateDto(){}

    public String getCodigo() {
        return codigo;
    }

    public BigDecimal getPercentualDesconto() {
        return percentualDesconto;
    }

    public LocalDate getValidade() {
        return validade;
    }
}

