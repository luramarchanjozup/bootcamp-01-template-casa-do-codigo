package br.com.zup.casadocodigo.utils;

import java.util.Collection;

public class Error {

    private Collection<String> mensagens;

    public Error(Collection<String> mensagens) {
        this.mensagens = mensagens;
    }

    public Collection<String> getMensagens() {
        return mensagens;
    }
}
