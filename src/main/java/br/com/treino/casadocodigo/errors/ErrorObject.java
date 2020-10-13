package br.com.treino.casadocodigo.errors;

public class ErrorObject {
    private final String mensagem;
    private final String campo;
    private final Object parametro;

    public ErrorObject(String mensagem, String campo, Object parametro) {
        this.mensagem = mensagem;
        this.campo = campo;
        this.parametro = parametro;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getCampo() {
        return campo;
    }

    public Object getParametro() {
        return parametro;
    }
}
