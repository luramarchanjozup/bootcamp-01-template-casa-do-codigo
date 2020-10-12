package dev.arielalvesdutrazup.cdc.controllers.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.arielalvesdutrazup.cdc.entities.Cupom;

import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class AlterarCupomRequestDTO {

    @NotBlank(message = "{codigo.notempty")
    private String codigo;
    @Future
    @NotNull(message = "{validade.notnull}")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime validade;
    @Min(1)
    @Max(100)
    @NotNull(message = "{percentualDeDesconto.notnull}")
    private Integer percentualDeDesconto;

    public AlterarCupomRequestDTO() {
    }

    public String getCodigo() {
        return codigo;
    }

    public AlterarCupomRequestDTO setCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public LocalDateTime getValidade() {
        return validade;
    }

    public AlterarCupomRequestDTO setValidade(LocalDateTime validade) {
        this.validade = validade;
        return this;
    }

    public Integer getPercentualDeDesconto() {
        return percentualDeDesconto;
    }

    public AlterarCupomRequestDTO setPercentualDeDesconto(Integer percentualDeDesconto) {
        this.percentualDeDesconto = percentualDeDesconto;
        return this;
    }

    public Cupom paraEntidade() {
        return new Cupom()
                .setCodigo(codigo)
                .setValidade(validade.atOffset(ZoneOffset.UTC))
                .setPercentualDeDesconto(percentualDeDesconto);
    }
}
