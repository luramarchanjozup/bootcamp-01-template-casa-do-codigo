package com.cdcAPI.api.model.Request;

import com.cdcAPI.model.Cupom;
import com.cdcAPI.validator.EntradaUnica;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

//Complexidade = 2
//EntradaUnica, Cupom

public class CupomEditarRequest {

    @NotBlank
    private String codigo;

    @NotNull
    @Min(value = 1)
    @Max(value = 100)
    private BigDecimal porcentagem;

    @NotNull
    @Future
    private LocalDate validade;

    public Cupom toModel() {
        return new Cupom(codigo, porcentagem, validade);
    }

    public void validaDuplicidade(Long cupomId, EntityManager manager) throws Exception {
        List<Cupom> validaExiste = manager.createQuery("SELECT c from Cupom c WHERE codigo=:codigo AND id !=:cupomId", Cupom.class)
                .setParameter("codigo", codigo)
                .setParameter("cupomId", cupomId)
                .getResultList();

        if (validaExiste.size() > 0) throw new Exception("Cupom com esse código já existe.");
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(BigDecimal porcentagem) {
        this.porcentagem = porcentagem;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }
}
