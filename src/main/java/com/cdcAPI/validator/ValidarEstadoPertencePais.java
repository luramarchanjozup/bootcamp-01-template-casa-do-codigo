package com.cdcAPI.validator;

import com.cdcAPI.api.model.Request.CompraRequest;
import com.cdcAPI.model.Estado;
import com.cdcAPI.model.Pais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class ValidarEstadoPertencePais implements Validator {

    @Autowired
    private EntityManager manager;

    @Override
    public boolean supports(Class<?> clazz) {
        return CompraRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        CompraRequest request = (CompraRequest) target;

        Pais pais = manager.find(Pais.class, request.getCliente().getPaisId());
        if (pais == null) {
            errors.rejectValue("cliente.paisId", null,
                    "Compra não pode ser efetuada. Pais não existe.");
            return;
        }

        Estado estado = manager.find(Estado.class, request.getCliente().getEstadoId());

        List<Estado> estadosList = manager
                .createQuery("SELECT e from Estado e WHERE pais = :pais", Estado.class)
                .setParameter("pais", pais)
                .getResultList();


        if (estadosList.size() > 0) {
            if (estado == null) {
                errors.rejectValue("cliente.estadoId", null,
                        "Campo 'estado' obrigatório.");

            } else if (!(estado.getPais()).equals(pais)) {
                errors.rejectValue("cliente.estadoId", null,"Compra não pode ser efetuada. Este estado não pertence ao país selecionado.");
            }

        } else if (estado != null) {
            errors.rejectValue("cliente.estadoId", null,
                    "Compra não pode ser efetuada. Este país não possui estados.");
        }
    }
}
