package br.com.zup.treinocasadocodigo.validators;

import br.com.zup.treinocasadocodigo.entities.Autor;
import br.com.zup.treinocasadocodigo.entities.NovoAutorRequest;
import br.com.zup.treinocasadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

/**
 * Contagem de carga intrínseca da classe: 3
 */

@Component
public class AutorValidator implements Validator {

    @Autowired
    //1
    private AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return NovoAutorRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        //1
        NovoAutorRequest novoAutor = (NovoAutorRequest) target;

        Optional<Autor> possivelAutor = autorRepository
                .findByEmail(novoAutor.getEmail());

        //1
        if (possivelAutor.isPresent()) {
            errors.rejectValue("email", null,
                    "já cadastrado: " + novoAutor.getEmail());
        }
    }
}
