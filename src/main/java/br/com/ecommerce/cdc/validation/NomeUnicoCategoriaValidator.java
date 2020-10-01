package br.com.ecommerce.cdc.validation;

import br.com.ecommerce.cdc.domain.Categoria;
import br.com.ecommerce.cdc.domain.CategoriaRequest;
import br.com.ecommerce.cdc.repository.CategoriaRepository;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;
/**
 * Carga intrinseca máxima permitida - 7
 * Carga intrinseca da classe - 3
 */

@Component
public class NomeUnicoCategoriaValidator implements Validator {
    // +1
    private final CategoriaRepository categoriaRepository;
    private final MessageSource messageSource;

    public NomeUnicoCategoriaValidator(CategoriaRepository categoriaRepository, MessageSource messageSource){
        this.categoriaRepository = categoriaRepository;
        this.messageSource = messageSource;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return CategoriaRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        // +1
        CategoriaRequest categoria = (CategoriaRequest) o;
        // +1
        Optional<Categoria> categoriaByNome = categoriaRepository.findByNome(categoria.getNome());

        if (categoriaByNome.isPresent()){
            errors.rejectValue("nome",null,getMessageResource());
        }

    }

    private String getMessageResource(){
        return messageSource.getMessage("categoria.nome.duplicado", null,LocaleContextHolder.getLocale());
    }
}
