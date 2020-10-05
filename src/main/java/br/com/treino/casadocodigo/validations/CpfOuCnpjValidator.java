package br.com.treino.casadocodigo.validations;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CpfOuCnpjValidator implements ConstraintValidator<CpfOuCnpj, Object> {

    @Override
    public void initialize(CpfOuCnpj constraintAnnotation) {} //1

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        CPFValidator cpfValidator = new CPFValidator(); //2
        cpfValidator.initialize(null);
        CNPJValidator cnpjValidator = new CNPJValidator(); //3
        cnpjValidator.initialize(null);

        return cpfValidator.isValid(value.toString(),null) ||
                cnpjValidator.isValid(value.toString(), null);
    }
}
