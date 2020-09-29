package br.com.treino.casadocodigo.validations;

import br.com.treino.casadocodigo.model.Autor;
import br.com.treino.casadocodigo.model.NovoAutorRequest;
import br.com.treino.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class EmailDuplicadoValidator implements Validator {

    @Autowired
    AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return NovoAutorRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        if (errors.hasErrors()) {
            return;
        }

        NovoAutorRequest request = (NovoAutorRequest) target;
        Optional<Autor> autor = autorRepository.findByEmail(request.getEmail());

        if (autor.isPresent()){
            errors.rejectValue("email", null, "Já existe um autor com " +
                    "esse mesmo email" + request.getEmail());
        }

    }
}
