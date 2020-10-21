package br.com.itau.casadocodigo.validador;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CPFouCNPJValidator implements ConstraintValidator<CPFouCNPJ, String> {

    int[] digito = new int[11];

    @Override
    public void initialize(CPFouCNPJ constraintAnnotation) {

    }

    @Override
    public boolean isValid(String cpfOuCnpj, ConstraintValidatorContext context) {
        if (cpfOuCnpj.length() == 14) {
            switch (cpfOuCnpj) {
                case "000.000.000-00" : case "111.111.111-11" : case "222.222.222-22" : case "333.333.333-33" :
                    case "444.444.444-44" : case "555.555.555-55" : case "666.666.666-66" : case "777.777.777-77" :
                        case "888.888.888-88" : case "999.999.999-99" :
                    return false;
            }

            String cpfSemPonto = cpfOuCnpj.replace(".", "");
            String cpfTexto = cpfSemPonto.replace("-", "");

            for (int i = 0; i < digito.length; i++) {
                int digitoNumero = Integer.parseInt(cpfTexto.substring(i, i + 1));
                digito[i] = digitoNumero;
            }

            double somaDigito1 = digito[0] * 10 + digito[1] * 9 + digito[2] * 8 + digito[3] * 7 + digito[4] * 6 + digito[5] * 5
                    + digito[6] * 4 + digito[7] * 3 + digito[8] * 2;

            int restoDigito1 = (int) (somaDigito1 * 10) % 11;

            if (restoDigito1 == 10) {
                restoDigito1 = 0;
            }

            double somaDigito2 = digito[0] * 11 + digito[1] * 10 + digito[2] * 9 + digito[3] * 8 + digito[4] * 7 + digito[5] * 6
                    + digito[6] * 5 + digito[7] * 4 + digito[8] * 3 + digito[9] * 2;

            int restoDigito2 = (int) ((somaDigito2 * 10) % 11);

            if (restoDigito2 == 10) {
                restoDigito2 = 0;
            }

            return digito[9] == restoDigito1 && digito[10] == restoDigito2;
        }

        if (cpfOuCnpj.length() == 18) {
            CNPJValidator cnpjValidator = new CNPJValidator();
            cnpjValidator.initialize(null);
            return cnpjValidator.isValid(cpfOuCnpj, null);
        }

        return false;
    }
}
