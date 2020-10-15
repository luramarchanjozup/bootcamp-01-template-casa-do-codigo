package br.com.carlos.casadocodigo.api.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter @Setter
public class ResponseCupomDto {
    private String codigo;
    private BigDecimal percentualDesconto;
    private LocalDate validade;
}
