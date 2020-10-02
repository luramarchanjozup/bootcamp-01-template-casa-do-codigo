package com.github.marcoscoutozup.casadocodigo.fluxocompra.validators;

import com.github.marcoscoutozup.casadocodigo.fluxocompra.compra.CompraDTO;
import com.github.marcoscoutozup.casadocodigo.pais.Pais;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class EstadoPertenceAPaisValidator implements Validator {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean supports(Class<?> aClass) {
        return CompraDTO.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        //1
        if(errors.hasErrors()){
            return;
        }
            //2
        CompraDTO compraDTO = (CompraDTO) o;

            //3
        if(compraDTO.getCliente().getEstado() != null){
            //4
            Pais pais = entityManager.find(Pais.class, compraDTO.getCliente().getPais());
            //5
            if(!pais.verificarSeEstadoPertenceAoPais(compraDTO.getCliente().getEstado())){
                errors.rejectValue( "cliente.estado", null,"O estado não está relacionado ao país");
            }
        }
    }
}
