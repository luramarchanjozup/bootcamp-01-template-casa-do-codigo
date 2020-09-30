package br.com.zup.bootcamp.controller.model;

import java.util.ArrayList;
import java.util.Collection;

// Intrinsic charge = 0
public class GenericResponse {
    private int status;
    private Collection<String> message;

    public GenericResponse(Collection<String> message, int status){
        this.message = message;
        this.status = status;
    }

    public GenericResponse(String message, int status){
        this.message = new ArrayList<String>();
        this.message.add(message);
        this.status = status;
    }

    public Collection<String> getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public void setMessage(Collection<String> message) {
        this.message = message;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
