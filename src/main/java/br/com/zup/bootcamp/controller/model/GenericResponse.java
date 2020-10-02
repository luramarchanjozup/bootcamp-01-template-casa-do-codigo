package br.com.zup.bootcamp.controller.model;

import java.util.ArrayList;
import java.util.Collection;

// Intrinsic charge = 0
public class GenericResponse {
    private Collection<?> message;

    public GenericResponse(){}

    public GenericResponse(Collection<String> message){
        this.message = message;
    }

    public GenericResponse(String message){
        ArrayList<String> messages = new ArrayList<>();
        messages.add(message);
        this.message = messages;
    }

    public Collection<?> getMessage() {
        return message;
    }

    public void setMessage(Collection<String> message) {
        this.message = message;
    }
}
