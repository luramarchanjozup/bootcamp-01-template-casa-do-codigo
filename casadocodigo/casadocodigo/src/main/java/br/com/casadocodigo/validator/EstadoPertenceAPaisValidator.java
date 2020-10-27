package br.com.casadocodigo.validator;

import br.com.casadocodigo.model.Estado;
import br.com.casadocodigo.model.NovaCompraRequest;
import br.com.casadocodigo.model.Pais;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class EstadoPertenceAPaisValidator {

    @PersistenceContext
    private EntityManager entityManager

    @Override
    public boolean supports(Class<?> clazz) {
        return NovaCompraRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()) {
            return;
        }

        NovaCompraRequest request = (NovaCompraRequest) target;

        if(request.temEstado()) {
            Pais pais = entityManager.find(Pais.class, request.getIdPais());
            Estado estado = entityManager.find(Estado.class, request.getIdEstado());
            if(!estado.pertenceAPais(pais)) {
                errors.rejectValue("idEstado",null,"estado não é o do país selecionado");
            }
        }
}
