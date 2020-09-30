package br.com.zup.bootcamp.controller.model;

import java.util.ArrayList;
import java.util.Collection;

// Intrinsic charge = 0
public class GenericResponse {
    private Collection<String> message;

    public GenericResponse(Collection<String> message){
        this.message = message;
    }

    public GenericResponse(String message){
        this.message = new ArrayList<String>();
        this.message.add(message);
    }

    public Collection<String> getMessage() {
        return message;
    }

    public void setMessage(Collection<String> message) {
        this.message = message;
    }
}
