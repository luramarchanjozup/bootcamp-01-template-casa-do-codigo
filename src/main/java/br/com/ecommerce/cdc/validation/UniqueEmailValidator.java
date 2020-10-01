package br.com.ecommerce.cdc.validation;


import br.com.ecommerce.cdc.domain.Autor;
import br.com.ecommerce.cdc.domain.AutorRequest;
import br.com.ecommerce.cdc.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Carga intrínseca máxima permitida - 7
 * Carga intrínseca da classe - 6
 */

@Component
public class UniqueEmailValidator implements Validator {

    @Autowired
    //+1
    private AutorRepository autorRepository;

    @Autowired
    //+1
    private MessageSource messageSource;

    @Override
    public boolean supports(Class<?> aClass) {
        return AutorRequest.class.equals(aClass);
    }

    @Override
    @Transactional
    public void validate(Object o, Errors errors) {
        // +1
        AutorRequest autorRequest = (AutorRequest) o;
        // +2
        Optional<Autor> authorByEmail = autorRepository.findByEmail(autorRequest.email());
        String mensagem = messageSource.getMessage("email.duplicado", null
                , LocaleContextHolder.getLocale());
        // +1
        if (!authorByEmail.isEmpty()){
            errors.rejectValue("email",null,mensagem);
        }
    }
}
