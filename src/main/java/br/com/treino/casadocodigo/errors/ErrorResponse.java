package br.com.treino.casadocodigo.errors;

import org.springframework.validation.ObjectError;

import java.util.List;

public class ErrorResponse {

    private final String mensagem;
    private final int codigo;
    private final String status;
    private final String nomeObjeto;
    private final List<ErrorObject> erros;

    public ErrorResponse(String mensagem, int codigo, String status,
                         String nomeObjeto, List<ErrorObject> erros) {
        this.mensagem = mensagem;
        this.codigo = codigo;
        this.status = status;
        this.nomeObjeto = nomeObjeto;
        this.erros = erros;
    }

    public String getMensagem() {
        return mensagem;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getStatus() {
        return status;
    }

    public String getNomeObjeto() {
        return nomeObjeto;
    }

    public List<ErrorObject> getErros() {
        return erros;
    }
}
