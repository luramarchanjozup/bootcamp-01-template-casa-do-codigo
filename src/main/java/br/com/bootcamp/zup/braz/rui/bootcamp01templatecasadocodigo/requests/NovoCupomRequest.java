package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.requests;

import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.annotation.ObjetoUnico;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.Cupom;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

public class NovoCupomRequest {

    @ObjetoUnico(fieldName = "codigo", domainClass = Cupom.class)
    @NotBlank
    private String codigo;
    @NotNull
    @Positive(message = "Valor do desconto precisa ser maior que zero")
    private Integer desconto;
    @NotNull
    @Future(message = "Validade precisa ser uma data futura.")
    private LocalDate validade;

    @Deprecated
    public NovoCupomRequest(){}

    public NovoCupomRequest(@NotBlank String codigo, @NotNull @Positive Integer desconto, @NotNull @Future LocalDate validade) {
        this.codigo = codigo;
        this.desconto = desconto;
        this.validade = validade;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getDesconto() {
        return desconto;
    }

    public void setDesconto(Integer desconto) {
        this.desconto = desconto;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public Cupom toModel(){
        return new Cupom(this.codigo, this.desconto, this.validade);
    }
}
