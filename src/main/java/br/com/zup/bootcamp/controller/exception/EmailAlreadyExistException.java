package br.com.zup.bootcamp.controller.exception;

public class EmailAlreadyExistException extends Exception {
    public EmailAlreadyExistException(String message){
        super(message);
    }
}
