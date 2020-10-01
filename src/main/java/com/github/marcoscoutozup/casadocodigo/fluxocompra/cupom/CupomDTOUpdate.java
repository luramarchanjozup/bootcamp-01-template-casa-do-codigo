package com.github.marcoscoutozup.casadocodigo.fluxocompra.cupom;

import org.springframework.http.ResponseEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

public class CupomDTOUpdate {

    @NotBlank
    private String codigo;

    @NotNull
    @Positive
    private Integer percentual;

    @Future
    private LocalDate validade;

    public Cupom updateCupom(Cupom cupom){
        cupom.setCodigo(codigo);
        cupom.setValidade(validade);
        cupom.setPercentual(percentual);
        return cupom;
    }

    public boolean validarCodigoDoCupom(Cupom cupom, EntityManager entityManager){
        Query query = entityManager.createQuery("select c from Cupom c where codigo = :codigo and id <> :id");
        query.setParameter("codigo", codigo);
        query.setParameter("id", cupom.getId());
        return !query.getResultList().isEmpty();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getPercentual() {
        return percentual;
    }

    public void setPercentual(Integer percentual) {
        this.percentual = percentual;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }
}
