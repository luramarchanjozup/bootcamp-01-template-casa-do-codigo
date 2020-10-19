package dev.arielalvesdutrazup.cdc.annotations.validators;

import dev.arielalvesdutrazup.cdc.annotations.Documento;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DocumentoValidator implements ConstraintValidator<Documento, String> {

    private CPFValidator cpfValidator;
    private CNPJValidator cnpjValidator;

    @Override
    public void initialize(Documento constraintAnnotation) {
        cpfValidator = new CPFValidator();
        cpfValidator.initialize(null);
        cnpjValidator = new CNPJValidator();
        cnpjValidator.initialize(null);
    }

    @Override
    public boolean isValid(String documento, ConstraintValidatorContext context) {
        return cpfValidator.isValid(documento, context)
                || cnpjValidator.isValid(documento, context);
    }
}
