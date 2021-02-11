package br.com.zup.cdc.nicolle.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.cdc.nicolle.model.Autor;
import br.com.zup.cdc.nicolle.repository.AutorRepository;
import br.com.zup.cdc.nicolle.request.NovoAutorRequest;

@RestController
@RequestMapping(value = "/casadocodigo/autores")
public class AutoresController {
	
	@Autowired
	private AutorRepository autorRepository;


	@PostMapping
	@Transactional
	@ResponseStatus(HttpStatus.CREATED)
	public void novo(@RequestBody @Valid NovoAutorRequest request) {
		Autor novoAutor = request.novoAutor();
		autorRepository.save(novoAutor);
		
	}
}
