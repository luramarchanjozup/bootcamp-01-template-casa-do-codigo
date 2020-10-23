package com.guiferrini.CasaCodigo.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.guiferrini.CasaCodigo.model.ErroPadrao;

@RestControllerAdvice
public class MeuHandlerAdvice {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErroPadrao> tratativa(MethodArgumentNotValidException methodArgumentNotValidException) {
		Collection<String> mensagens = new ArrayList<>(); //diferença entre Collectio e List - o resultado foi aparentemente igual 
		BindingResult bindinResult = methodArgumentNotValidException.getBindingResult();
		List<FieldError> campoDoErros = bindinResult.getFieldErrors();
		campoDoErros.forEach(campoDoErro -> {
			String mensagem = String.format("ERRO no Campo - " + campoDoErro.getField() + ": " + campoDoErro.getDefaultMessage());
			mensagens.add(mensagem);
		});
		
		ErroPadrao erroPadrao = new ErroPadrao(mensagens);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroPadrao);		
	}
}
