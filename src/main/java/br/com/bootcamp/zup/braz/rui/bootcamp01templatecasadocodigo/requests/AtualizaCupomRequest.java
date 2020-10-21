package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.requests;

import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.annotation.ObjetoUnico;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.Cupom;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

public class AtualizaCupomRequest {

    @NotNull
    private Integer id;
    @NotBlank
    @ObjetoUnico(domainClass = Cupom.class, fieldName = "codigo")
    private String codigo;
    @NotNull
    @Positive
    private Integer desconto;
    @NotNull
    @Future
    private LocalDate validade;

    @Deprecated
    public AtualizaCupomRequest(){}


    public AtualizaCupomRequest(Integer id, @NotBlank String codigo, @NotNull @Positive Integer desconto, @NotNull @Future LocalDate validade) {
        this.id = id;
        this.codigo = codigo;
        this.desconto = desconto;
        this.validade = validade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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


}
