package br.com.carlos.casadocodigo.api.dto.request;

import br.com.carlos.casadocodigo.api.handler.Unique;
import br.com.carlos.casadocodigo.domain.entity.Cupom;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter @Setter
public class RequestCupomDto {
    @NotBlank @Unique(domainClass = Cupom.class, fieldName = "codigo")
    private String codigo;
    @Min(20)
    private BigDecimal percentualDesconto;
    @Future @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate validade;
}
