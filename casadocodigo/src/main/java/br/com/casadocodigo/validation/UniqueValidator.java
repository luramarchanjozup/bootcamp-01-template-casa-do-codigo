package br.com.casadocodigo.validation;
import br.com.casadocodigo.models.Author;
import br.com.casadocodigo.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class UniqueValidator implements ConstraintValidator<Unique, String> {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public void initialize(Unique constraintAnnotation) {
    }

    @Override
    public boolean isValid(String input, ConstraintValidatorContext constraintValidatorContext) {

        if(authorRepository.findByEmail(input) != null){

            return false;

        }

        return true;

    }
}
