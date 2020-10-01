package com.github.marcoscoutozup.casadocodigo.fluxocompra.cupom;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class AplicarCupomDTO {

    private String codigo;

    public boolean validarCupom(EntityManager entityManager){
        Query query = entityManager.createQuery("select c from Cupom c where :codigo like codigo", Cupom.class);
        query.setParameter("codigo", codigo);
        Cupom cupom = (Cupom) query.getSingleResult();
        return cupom != null && cupom.estaValido();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
