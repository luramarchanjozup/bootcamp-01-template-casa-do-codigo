package br.com.zup.bootcamp.controller.model;

import java.util.ArrayList;
import java.util.Collection;

// Intrinsic charge = 0
public class GenericResponse {
    private Collection<?> message;

    public GenericResponse(){}

    public GenericResponse(Collection<?> messages){
        this.message = messages;
    }

    public <T> GenericResponse(T message){
        ArrayList<T> messages = new ArrayList<>();
        messages.add(message);
        this.message = messages;
    }

    public Collection<?> getMessage() {
        return message;
    }

    public void setMessage(Collection<?> message) {
        this.message = message;
    }
}
