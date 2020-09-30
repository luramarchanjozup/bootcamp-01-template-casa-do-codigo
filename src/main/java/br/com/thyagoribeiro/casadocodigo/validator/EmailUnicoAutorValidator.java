package br.com.thyagoribeiro.casadocodigo.validator;

import br.com.thyagoribeiro.casadocodigo.domain.Autor;
import br.com.thyagoribeiro.casadocodigo.repository.AutorRepository;
import br.com.thyagoribeiro.casadocodigo.rest.contract.NovoAutorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class EmailUnicoAutorValidator implements Validator {

    @Autowired
    private AutorRepository autorRepository;

    public EmailUnicoAutorValidator(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return NovoAutorRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        NovoAutorRequest novoAutor = (NovoAutorRequest) target;
        Optional<Autor> findResult = autorRepository.findByEmail(novoAutor.getEmail());

        if (!findResult.isEmpty())
            errors.rejectValue("email", null, "já foi criado em outro registro");

    }

}
