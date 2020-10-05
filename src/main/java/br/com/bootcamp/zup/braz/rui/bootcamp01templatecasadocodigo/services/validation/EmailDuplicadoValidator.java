package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.services.validation;

import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class EmailDuplicadoValidator implements ConstraintValidator<EmailDuplicado, String> {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext cValidatorContext) {

        return !autorRepository.findByEmail(email).isPresent();
    }

}
