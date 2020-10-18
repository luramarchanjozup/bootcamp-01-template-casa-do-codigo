package io.github.evertoncnsouza.rest.controller;

import io.github.evertoncnsouza.validation.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice //Essa annotation permite tratar exceções em toda Api;
public class HandlerAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class) //@ExceptionHandler é o método para tratar o erro;
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleMethodNotValidException(MethodArgumentNotValidException ex){
        List<String> errors =  ex.getBindingResult().getAllErrors()
                .stream()
                .map( erro -> erro.getDefaultMessage() )
                .collect(Collectors.toList() );
        return new ApiErrors(errors);
    }
//Basicamente toda vez que a API passa por um MethodArgumentNotValidException do pacote SpringFramework Web Bind,
//onde uma exception é lançada,ele pega a mensagem de erro com um get e retorna a mensagem de erro.
//BindingResult,carrega a mensagem, o dado de validação que falhou.
// O Map erro, retornará a mensagem especificada na validação.
// O Collect coleta todas as mensagem(toList).
}
