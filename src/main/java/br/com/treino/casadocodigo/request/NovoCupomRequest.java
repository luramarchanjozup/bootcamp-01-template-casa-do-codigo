package br.com.treino.casadocodigo.request;

import br.com.treino.casadocodigo.model.Cupom;
import br.com.treino.casadocodigo.validations.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

public class NovoCupomRequest {

    @NotBlank
    @UniqueValue(className = Cupom.class, fieldName = "codigo",
    message = "Esse código já foi cadastrado")
    private String codigo;
    @NotNull @Positive
    private BigDecimal percentualDesconto;
    @NotNull
    @Future
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate validade;

    @Deprecated
    public NovoCupomRequest(){}

    public NovoCupomRequest(@NotBlank String codigo,
                            @Positive BigDecimal percentualDesconto,
                            @Future LocalDate validade) {
        this.codigo = codigo;
        this.percentualDesconto = percentualDesconto;
        this.validade = validade;
    }

    public String getCodigo() { return codigo; }

    public BigDecimal getPercentualDesconto() { return percentualDesconto; }

    public LocalDate getValidade() { return validade; }

    public void setValidade(LocalDate validade) { this.validade = validade; }

    public Cupom toModel(){
        return new Cupom(this.codigo, this.percentualDesconto,this.validade);
    }
}
