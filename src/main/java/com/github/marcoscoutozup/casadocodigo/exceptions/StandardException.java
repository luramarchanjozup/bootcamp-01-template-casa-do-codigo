package com.github.marcoscoutozup.casadocodigo.exceptions;

import java.util.List;

public class StandardException {

    private List<String> messages;

    public StandardException(List<String> messages) {
        this.messages = messages;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}
