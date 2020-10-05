package br.com.casadocodigo.exceptions;

import java.util.Collection;

public class DefaultError {

    private Collection<String> messages;

    public DefaultError(Collection<String> messages) {

        this.messages = messages;

    }
}
