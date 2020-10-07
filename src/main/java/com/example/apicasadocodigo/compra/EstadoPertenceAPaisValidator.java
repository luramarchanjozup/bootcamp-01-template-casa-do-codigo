package com.example.apicasadocodigo.compra;

import com.example.apicasadocodigo.localidade.Estado;
import com.example.apicasadocodigo.localidade.Pais;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class EstadoPertenceAPaisValidator implements Validator {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public boolean supports(Class<?> clazz) {
        return NovaCompraRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        NovaCompraRequest request = (NovaCompraRequest) target;

        if (request.getIdEstado() != null) {
            Pais pais = manager.find(Pais.class, request.getIdPais());
            Estado estado = manager.find(Estado.class, request.getIdEstado());
            if (!estado.getPais().equals(pais)) {
                errors.rejectValue("idEstado", null, "Este estado não é do país selecionado");
            }
        }
    }
}