package com.github.marcoscoutozup.casadocodigo.validator.codigodecupom;

import com.github.marcoscoutozup.casadocodigo.fluxocompra.cupom.Cupom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CupomValidoParaCompraValidator implements ConstraintValidator<CupomValidoParaCompra, String> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(CupomValidoParaCompra constraintAnnotation) {

    }

    @Override
    public boolean isValid(String codigoDeCupom, ConstraintValidatorContext constraintValidatorContext) {
        return codigoDeCupom == null || verificarValidadeDoCupom(codigoDeCupom);
    }

    private boolean verificarValidadeDoCupom(String codigoDeCupom){
        TypedQuery<Cupom> query = entityManager.createNamedQuery("findCupomByCodigo", Cupom.class);
        query.setParameter("codigo", codigoDeCupom);
        return !query.getResultList().isEmpty() && query.getSingleResult().estaValido();
    }
}
