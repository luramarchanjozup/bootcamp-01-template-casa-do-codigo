package br.com.ecommerce.cdc.validation;

import br.com.ecommerce.cdc.anotacao.CPFouCNPJ;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CPFouCNPJValidator implements ConstraintValidator<CPFouCNPJ, String> {


    @Override
    public void initialize(CPFouCNPJ constraintAnnotation) {
        return;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if ( value.length() == 11 || value.length()==14){
            return true;
        }

        return false;
    }
}
