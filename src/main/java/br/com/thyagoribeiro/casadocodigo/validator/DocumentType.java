package br.com.thyagoribeiro.casadocodigo.validator;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;

import javax.validation.ConstraintValidator;

public enum DocumentType {

    CPF(new CPFValidator()), CNPJ(new CNPJValidator());

    private ConstraintValidator constraintValidator;

    DocumentType(ConstraintValidator constraintValidator) {
        this.constraintValidator = constraintValidator;
    }

    public ConstraintValidator getConstraintValidator() {
        return constraintValidator;
    }
}
