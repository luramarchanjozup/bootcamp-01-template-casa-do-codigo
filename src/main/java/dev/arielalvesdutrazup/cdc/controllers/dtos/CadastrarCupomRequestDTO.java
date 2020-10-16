package dev.arielalvesdutrazup.cdc.controllers.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.arielalvesdutrazup.cdc.entities.Cupom;

import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class CadastrarCupomRequestDTO {

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

    public CadastrarCupomRequestDTO() {
    }

    public String getCodigo() {
        return codigo;
    }

    public CadastrarCupomRequestDTO setCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public LocalDateTime getValidade() {
        return validade;
    }

    public CadastrarCupomRequestDTO setValidade(LocalDateTime validade) {
        this.validade = validade;
        return this;
    }

    public Integer getPercentualDeDesconto() {
        return percentualDeDesconto;
    }

    public CadastrarCupomRequestDTO setPercentualDeDesconto(Integer percentualDeDesconto) {
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
