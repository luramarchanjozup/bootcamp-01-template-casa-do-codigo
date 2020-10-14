package br.com.ecommerce.cdc.validation;

import br.com.ecommerce.cdc.domain.request.CompraRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Carga Intrínseca máxima permitida - 7
 * Carga Intrínseca da classe - 3
 *
 */

@Component
public class EstadoPertecePaisValidator implements Validator {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private MessageSource messageSource;

    @Override
    public boolean supports(Class<?> aClass) {
        return CompraRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        // +1
        CompraRequest compraRequest = (CompraRequest) o;

        Query query = manager.createQuery("select c from Estado c where c.id =:estado and c.pais.id =:value");
        query.setParameter("estado", compraRequest.getEstadoId())
                .setParameter("value", compraRequest.getPaisId());
        // +1
        List<?> estadoBusca = query.getResultList();

        String erroMensagem = messageSource.getMessage("estado.nao.pertence.a.pais",null, LocaleContextHolder.getLocale());
        // +1
        if (estadoBusca.size() == 0 ){
            errors.rejectValue("estadoId", null,erroMensagem);
        }

        /*
        // outra forma de fazer
        Optional<Estado> estadoBusca = estadoRepository.findByIdAndPaisId(cadastroRequest.getEstadoId(), cadastroRequest.getPaisId());
        String erroMensagem = messageSource.getMessage("estado.nao.pertence.a.pais",null, LocaleContextHolder.getLocale());
        if (!estadoBusca.isPresent()){
            errors.rejectValue("estadoId", null,erroMensagem);
        }
        */
    }
}
