package br.com.itau.casadocodigo.cadastrocategoria.model;

public class ResultadoCategoriaResponse {

    private final String mensagem;

    public ResultadoCategoriaResponse(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public static ResultadoCategoriaResponse duplicado(String cadastro) {
        return new ResultadoCategoriaResponse("O nome da categoria (" + cadastro + ") já está cadastrada. Utilize outro.");
    }

    public ResultadoCategoriaResponse get() {
        return new ResultadoCategoriaResponse(mensagem);
    }
}
