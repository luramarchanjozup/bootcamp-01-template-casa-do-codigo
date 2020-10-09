package br.com.treino.casadocodigo.validations;

import br.com.treino.casadocodigo.model.Estado;
import br.com.treino.casadocodigo.model.Pais;
import br.com.treino.casadocodigo.request.NovaCompraRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class EstadoPertenceAoPaisValidator implements Validator {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean supports(Class<?> clazz) {
        return NovaCompraRequest.class.isAssignableFrom(clazz); //1
    }

    @Override
    public void validate(Object target, Errors errors) {

        if(errors.hasErrors()){ //2
            return;
        }

        NovaCompraRequest request = (NovaCompraRequest) target;

        if(request.temEstado()){ //3
            Pais pais = entityManager.find(Pais.class, request.getIdPais()); //5
            Estado estado = entityManager.find(Estado.class, request.getIdEstado()); //6

            if (!estado.perteceAoPais(pais)){ //4
                errors.rejectValue("idEstado", null,
                        " esse Estado não é do País selecionado");
            }
        }



    }
}
