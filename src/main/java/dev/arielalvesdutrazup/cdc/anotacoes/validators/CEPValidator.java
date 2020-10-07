package dev.arielalvesdutrazup.cdc.anotacoes.validators;

import dev.arielalvesdutrazup.cdc.anotacoes.CEP;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CEPValidator implements ConstraintValidator<CEP, String> {
    private final String CEP_REGEX = "^[0-9]{8}$";

    @Override
    public void initialize(CEP constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && value.matches(CEP_REGEX);
    }
}
