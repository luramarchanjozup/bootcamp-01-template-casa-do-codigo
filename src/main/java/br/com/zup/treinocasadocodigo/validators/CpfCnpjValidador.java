package br.com.zup.treinocasadocodigo.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.InputMismatchException;

/**
 * Contagem de carga intrínseca da classe: 23
 */
/*
 Fonte da validação CPF/CNPJ: https://receitasdecodigo.com.br/java/classe-java-completa-para-gerar-e-validar-cpf-e-cnpj
 */

public class CpfCnpjValidador implements ConstraintValidator<CpfCnpj, String> {

    @Override
    public void initialize(CpfCnpj constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return (isCPF(value) || isCNPJ(value));
    }

    public boolean isCPF(String CPF) {

        CPF = removeCaracteresEspeciais(CPF);

        //1
        // Considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000")
                || CPF.equals("11111111111")
                || CPF.equals("22222222222")
                || CPF.equals("33333333333")
                || CPF.equals("44444444444")
                || CPF.equals("55555555555")
                || CPF.equals("66666666666")
                || CPF.equals("77777777777")
                || CPF.equals("88888888888")
                || CPF.equals("99999999999")
                || (CPF.length() != 11)
        ) {
            return (false);
        }

        char dig10, dig11;
        int sm, i, r, num, peso;

        //2
        // Protege o codigo para eventuais erros de conversao de tipo (int)
        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            //1
            for (i = 0; i < 9; i++) {
                // Converte o i-esimo caractere do CPF em um numero:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posicao de '0' na tabela ASCII)
                num = CPF.charAt(i) - 48;
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            //2
            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                dig10 = (char) (r + 48); // Converte no respectivo caractere numerico
            }

            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            //1
            for (i = 0; i < 10; i++) {
                num = CPF.charAt(i) - 48;
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            //2
            if ((r == 10) || (r == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char) (r + 48);
            }

            // Verifica se os digitos calculados conferem com os digitos informados.
            return ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)));
        } catch (InputMismatchException erro) {
            return (false);
        }
    }

    public boolean isCNPJ(String CNPJ) {

        CNPJ = removeCaracteresEspeciais(CNPJ);

        //1
        // Considera-se erro CNPJ's formados por uma sequencia de numeros iguais
        if (CNPJ.equals("00000000000000")
                || CNPJ.equals("11111111111111")
                || CNPJ.equals("22222222222222")
                || CNPJ.equals("33333333333333")
                || CNPJ.equals("44444444444444")
                || CNPJ.equals("55555555555555")
                || CNPJ.equals("66666666666666")
                || CNPJ.equals("77777777777777")
                || CNPJ.equals("88888888888888")
                || CNPJ.equals("99999999999999")
                || (CNPJ.length() != 14)
        ) {
            return (false);
        }

        char dig13, dig14;
        int sm, i, r, num, peso;

        //2
        // Protege o código para eventuais erros de conversao de tipo (int)
        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 2;
            //1
            for (i = 11; i >= 0; i--) {
                // Converte o i-ésimo caractere do CNPJ em um número:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posição de '0' na tabela ASCII)
                num = CNPJ.charAt(i) - 48;
                sm = sm + (num * peso);
                peso = peso + 1;
                //1
                if (peso == 10) {
                    peso = 2;
                }
            }

            r = sm % 11;
            //2
            if ((r == 0) || (r == 1)) {
                dig13 = '0';
            } else {
                dig13 = (char) ((11 - r) + 48);
            }

            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 2;
            //1
            for (i = 12; i >= 0; i--) {
                num = CNPJ.charAt(i) - 48;
                sm = sm + (num * peso);
                peso = peso + 1;
                //1
                if (peso == 10) {
                    peso = 2;
                }
            }

            r = sm % 11;
            //2
            if ((r == 0) || (r == 1)) {
                dig14 = '0';
            } else {
                dig14 = (char) ((11 - r) + 48);
            }

            // Verifica se os dígitos calculados conferem com os dígitos informados.
            return ((dig13 == CNPJ.charAt(12)) && (dig14 == CNPJ.charAt(13)));
        } catch (InputMismatchException erro) {
            return (false);
        }
    }

    private String removeCaracteresEspeciais(String doc) {
        //1
        if (doc.contains(".")) {
            doc = doc.replace(".", "");
        }
        //1
        if (doc.contains("-")) {
            doc = doc.replace("-", "");
        }
        //1
        if (doc.contains("/")) {
            doc = doc.replace("/", "");
        }
        return doc;
    }

}
