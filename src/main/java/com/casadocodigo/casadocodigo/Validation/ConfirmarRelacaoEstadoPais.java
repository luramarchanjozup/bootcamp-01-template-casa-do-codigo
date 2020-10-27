package com.casadocodigo.casadocodigo.Validation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.casadocodigo.casadocodigo.Estado.Estado;
import com.casadocodigo.casadocodigo.FluxoPagamento.Compra.CompraDto;
import com.casadocodigo.casadocodigo.Pais.Pais;

@Component
public class ConfirmarRelacaoEstadoPais implements Validator {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public boolean supports(Class<?> clazz) {
        return CompraDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        CompraDto request = (CompraDto) target;

        if (request.getIdEstado() != null) {
            Pais pais = manager.find(Pais.class, request.getIdPais());
            Estado estado = manager.find(Estado.class, request.getIdEstado());
            if (!estado.getPais().equals(pais)) {
                errors.rejectValue("idEstado", null, "Este estado não pertence a este país!");
            }
        }
    }
}
