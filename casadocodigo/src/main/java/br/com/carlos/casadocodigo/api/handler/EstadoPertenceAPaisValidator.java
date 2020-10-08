package br.com.carlos.casadocodigo.api.handler;

import br.com.carlos.casadocodigo.api.dto.RequestCompraDto;
import br.com.carlos.casadocodigo.domain.entity.Estado;
import br.com.carlos.casadocodigo.domain.entity.Pais;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EstadoPertenceAPaisValidator implements Validator {

    @PersistenceContext
    private EntityManager manager;
    
    @Override
    public boolean supports(Class<?> clazz) {
        return RequestCompraDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()) {
            return;
        }

        RequestCompraDto request = (RequestCompraDto) target;

        Pais pais = manager.find(Pais.class, request.getPais().getId());
        Estado estado = manager.find(Estado.class, request.getEstado().getId());

        if(!estado.pertenceAPais(pais)) {
            errors.rejectValue("idEstado",null,"este estado não é o do país selecionado");
        }

    }
}
