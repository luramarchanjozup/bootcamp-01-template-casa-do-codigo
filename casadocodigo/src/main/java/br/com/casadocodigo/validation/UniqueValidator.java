package br.com.casadocodigo.validation;
import br.com.casadocodigo.models.Author;
import br.com.casadocodigo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class UniqueValidator implements ConstraintValidator<Unique, String> {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private CouponRepository couponRepository;

    @Override
    public void initialize(Unique constraintAnnotation) {
    }

    @Override
    public boolean isValid(String input, ConstraintValidatorContext constraintValidatorContext) {

        return authorRepository.findByEmail(input) == null
                && categoryRepository.findByName(input) == null
                && bookRepository.findByTitle(input) == null
                && bookRepository.findByIsbn(input) == null
                && countryRepository.findByName(input) == null
                && stateRepository.findByName(input) == null
                && couponRepository.findByCode(input) == null;

    }
}
