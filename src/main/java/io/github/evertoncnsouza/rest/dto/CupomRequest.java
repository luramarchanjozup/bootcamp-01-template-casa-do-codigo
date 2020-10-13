package io.github.evertoncnsouza.rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.evertoncnsouza.domain.entity.Cupom;
import io.github.evertoncnsouza.validation.constraint.valitation.UniqueValue;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

//Não tem PCI;
public class CupomRequest {

    @NotBlank
    @UniqueValue(domainClass = Cupom.class, fieldName = "codigo")
    private String codigo;

    @Positive
    @NotNull
    private BigDecimal percentualDesconto;

    @Future
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate validade;

    public CupomRequest(@NotBlank String codigo, @Positive @NotNull
            BigDecimal percentualDesconto) {
        super();
        this.codigo = codigo;
        this.percentualDesconto = percentualDesconto;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public Cupom toModel() {
        return new Cupom(codigo, percentualDesconto, validade);
    }
}
