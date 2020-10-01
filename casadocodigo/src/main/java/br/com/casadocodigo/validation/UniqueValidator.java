package br.com.casadocodigo.validation;
import br.com.casadocodigo.models.Author;
import br.com.casadocodigo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class UniqueValidator implements ConstraintValidator<Unique, String> {

    // +1
    @Autowired
    private AuthorRepository authorRepository;

    // +1
    @Autowired
    private CategoryRepository categoryRepository;

    // +1
    @Autowired
    private BookRepository bookRepository;

    // +1
    @Autowired
    private CountryRepository countryRepository;

    // +1
    @Autowired
    private StateRepository stateRepository;

    // +1
    @Autowired
    private CouponRepository couponRepository;

    // +1
    @Override
    public void initialize(Unique constraintAnnotation) {
    }

    @Override
    public boolean isValid(String input, ConstraintValidatorContext constraintValidatorContext) {

        // +1
        if(authorRepository.findByEmail(input) == null
                && categoryRepository.findByName(input) == null
                && bookRepository.findByTitle(input) == null
                && bookRepository.findByIsbn(input) == null
                && countryRepository.findByName(input) == null
                && stateRepository.findByName(input) == null
                && couponRepository.findByCode(input) == null){

            return true;

        }

        return false;

    }
}
