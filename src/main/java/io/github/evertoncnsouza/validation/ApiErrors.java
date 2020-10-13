package io.github.evertoncnsouza.validation;

import java.util.List;

public class ApiErrors {

    private List<String> errors; //Lista de Strings do pacote Java.util para padronização;

    public List<String> getErrors() { //Método get, para gerar um get errors, para obtermos os erros.
        return errors;
    }

    public ApiErrors(List<String> errors) { //É necessário um construtor para receber a mensagem e retornar os erros;
        this.errors = errors;

    }
}
