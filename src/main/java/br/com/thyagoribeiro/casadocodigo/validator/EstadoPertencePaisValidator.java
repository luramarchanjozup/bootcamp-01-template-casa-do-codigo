package br.com.thyagoribeiro.casadocodigo.validator;

import br.com.thyagoribeiro.casadocodigo.rest.contract.NovaCompraRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

// CDD - Total: 3

@Component
public class EstadoPertencePaisValidator implements Validator {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean supports(Class<?> clazz) {
        return NovaCompraRequest.class.isAssignableFrom(clazz); // CDD 1 - Classe NovaCompraRequest
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()) // CDD 1 - branch if
            return;

        NovaCompraRequest novaCompraRequest = (NovaCompraRequest) target;

        Query query = entityManager.createQuery("SELECT 1 FROM Estado WHERE id = :estadoId AND paisId = :paisId");
        query.setParameter("estadoId", novaCompraRequest.getEstadoId());
        query.setParameter("paisId", novaCompraRequest.getPaisId());

        List<?> result = query.getResultList();
        boolean exists = result.size() > 0;

        if(!exists) // CDD 1 - branch if
            errors.rejectValue("estadoId", null, "deve pertencer ao país enviado");

    }
}
