package bootcamp.challenges.casadocodigo.validators;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CpfCnpjValidator implements ConstraintValidator<CpfCnpj, String> {
    CPFValidator cpfValidator;
    CNPJValidator cnpjValidator;
    @Override
    public void initialize(CpfCnpj cpfCnpjAnnotation) {
        cpfValidator = new CPFValidator();
        cpfValidator.initialize(null);
        cnpjValidator = new CNPJValidator();
        cnpjValidator.initialize(null);
    }

    @Override
    public boolean isValid(String personId, ConstraintValidatorContext constraintValidatorContext) {
        return cpfValidator.isValid(personId,constraintValidatorContext) || cnpjValidator.isValid(personId,constraintValidatorContext);
    }
}
