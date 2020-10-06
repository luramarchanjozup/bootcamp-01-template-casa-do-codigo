package com.github.marcoscoutozup.casadocodigo.validator.cpfoucnpj;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CpfOuCnpjValidator implements ConstraintValidator<CpfOuCpj, String> {

    private CPFValidator cpfValidator;
    private CNPJValidator cnpjValidator;

    @Override
    public void initialize(CpfOuCpj constraintAnnotation) {
        cpfValidator = new CPFValidator();
        cnpjValidator= new CNPJValidator();
        cpfValidator.initialize(null);
        cnpjValidator.initialize(null);
    }

    @Override
    public boolean isValid(String documento, ConstraintValidatorContext constraintValidatorContext) {
        return documento != null && (cpfValidator.isValid(documento, null) || cnpjValidator.isValid(documento, null));
    }
}
