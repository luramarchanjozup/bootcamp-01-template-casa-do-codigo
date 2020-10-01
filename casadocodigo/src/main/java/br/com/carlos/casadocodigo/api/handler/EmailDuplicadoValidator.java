package br.com.carlos.casadocodigo.api.handler;

import br.com.carlos.casadocodigo.api.dto.RequestAutorDto;
import br.com.carlos.casadocodigo.domain.entity.Autor;
import br.com.carlos.casadocodigo.domain.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;


@Component
public class EmailDuplicadoValidator implements Validator {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return RequestAutorDto.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object alvo, Errors errors) {
        if (errors.hasErrors()){
            return;
        }

        RequestAutorDto requestAutorDto = (RequestAutorDto) alvo;

        Optional<Autor> emailExiste = autorRepository.findByEmail(requestAutorDto.getEmail());
        System.out.println(emailExiste);
        if (emailExiste.isPresent()){

            errors.rejectValue("email", null, requestAutorDto.getEmail()+" duplicado.");
        }
    }
}
