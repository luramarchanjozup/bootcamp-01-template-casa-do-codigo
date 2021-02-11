package com.casaDoCodigo.Nicolle.Autor;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

//import org.springframework.http.HttpStatus.CREATED

@RestController
public class AutoresController {
	
	@Autowired
	private AutorRepository autorRepository;


	@PostMapping(value = "/casa/autor")
	@Transactional
	@ResponseStatus(HttpStatus.CREATED)
	public void novo(@RequestBody @Valid NovoAutorForm form) {
		Autor novoAutor = form.novoAutor();
		autorRepository.save(novoAutor);
	}
}
